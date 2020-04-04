package org.featx.spec.feature

/**
 * @author : Excepts
 * @since : 2020/4/4 15:15
 */
class SnowflakeIdWorker(workerId: Long, dataCenterId: Long) : IdGenerate {
    private val epoch = 1420041600000L
    private val workerIdBits = 5L
    private val dataCenterIdBits = 5L
    private val maxWorkerId = -1L xor (-1L shl workerIdBits.toInt())
    private val maxDataCenterId = -1L xor (-1L shl dataCenterIdBits.toInt())
    private val sequenceBits = 12L
    private val workerIdShift = sequenceBits
    private val dataCenterIdShift = sequenceBits + workerIdBits
    private val timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits
    private val sequenceMask = -1L xor (-1L shl sequenceBits.toInt())
    private val workerId: Long
    private val dataCenterId: Long
    private var sequence = 0L
    private var lastTimestamp = -1L
    // ==============================Methods==========================================
    /**
     *
     * @return SnowflakeId
     */
    @Synchronized
    override fun nextId(): Long {
        var timestamp = timeGen()
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
        return (timestamp - epoch shl timestampLeftShift.toInt()
                or (dataCenterId shl dataCenterIdShift.toInt())
                or (workerId shl workerIdShift.toInt())
                or sequence)
    }

    /**
     * @param lastTimestamp 上次生成ID的时间截
     * @return
     */
    protected fun tilNextMillis(lastTimestamp: Long): Long {
        var timestamp = timeGen()
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen()
        }
        return timestamp
    }

    /**
     * @return 当前时间(毫秒)
     */
    protected fun timeGen(): Long {
        return System.currentTimeMillis()
    }
    //==============================Constructors=====================================
    /**
     *
     * @param workerId 工作ID (0~31)
     * @param dataCenterId 数据中心ID (0~31)
     */
    init {
        require(!(workerId > maxWorkerId || workerId < 0)) { String.format("worker Id can't be greater than %d or less than 0", maxWorkerId) }
        require(!(dataCenterId > maxDataCenterId || dataCenterId < 0)) { String.format("datacenter Id can't be greater than %d or less than 0", maxDataCenterId) }
        this.workerId = workerId
        this.dataCenterId = dataCenterId
    }
}