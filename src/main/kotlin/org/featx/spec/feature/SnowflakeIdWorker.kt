package org.featx.spec.feature

/**
 * @author : Excepts
 * @since : 2020/4/4 15:15
 */
open class SnowflakeIdWorker(epoch: Long, workerId: Long, dataCenterId: Long) : IdGenerate {
    /**
     * Machine instance id bits length
     */
    private val workerIdBits = 5

    /**
     * Data center id bits length
     */
    private val dataCenterIdBits = 5

    /**
     * Bits length of The sequence in the same second
     */
    private val sequenceBits = 12

    /**
     * The max value of machine instance id
     */
    private val maxWorkerId = -1L xor (-1L shl workerIdBits)

    /**
     * The max value of data center id
     */
    private val maxDataCenterId = -1L xor (-1L shl dataCenterIdBits)

    /**
     * The offset from right lowest bit for machine instance id
     */
    private val workerIdShift = sequenceBits

    /**
     * The offset from right lowest bit for data center id
     */
    private val dataCenterIdShift = sequenceBits + workerIdBits

    /**
     * The offset from right lowest bit for timestamp
     */
    private val timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits

    /**
     * The sequence mask
     */
    private val sequenceMask = -1L xor (-1L shl sequenceBits)


    private val epoch: Long

    private val workerId: Long

    private val dataCenterId: Long

    private var sequence = 0L

    private var lastTimestamp = -1L

    init {
        require(!(workerId > maxWorkerId || workerId < 0))
        { String.format("worker Id can't be greater than %d or less than 0", maxWorkerId) }
        require(!(dataCenterId > maxDataCenterId || dataCenterId < 0))
        { String.format("datacenter Id can't be greater than %d or less than 0", maxDataCenterId) }
        this.epoch = epoch
        this.workerId = workerId
        this.dataCenterId = dataCenterId
    }
    // ==============================Methods==========================================
    /**
     *
     * @return SnowflakeId
     */
    @Synchronized
    override fun nextId(): Long {
        var timestamp = tickNextMill()
        if (timestamp < lastTimestamp) {
            throw RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp))
        }
        if (lastTimestamp == timestamp) {
            sequence = sequence + 1 and sequenceMask
            if (sequence == 0L) {
                timestamp = tilNextMillis(lastTimestamp)
            }
        } else {
            sequence = 0L
        }
        lastTimestamp = timestamp
        /* 42 bits of timestamp */
        return ( (timestamp - epoch) shl timestampLeftShift
                /* 5 bits of data center id */
                or (dataCenterId shl dataCenterIdShift)
                /* 5 bits of machine id */
                or (workerId shl workerIdShift)
                /* 12 bits of sequence */
                or sequence)
    }

    /**
     * @param lastTimestamp 上次生成ID的时间截
     * @return
     */
    private fun tilNextMillis(lastTimestamp: Long): Long {
        var timestamp: Long
        do {
            timestamp = tickNextMill()
        } while (timestamp <= lastTimestamp)
        return timestamp
    }

    /**
     * @return 当前时间(毫秒)
     */
    fun tickNextMill(): Long {
        return System.currentTimeMillis()
    }
}