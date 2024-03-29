package priv.java.base.common.util;

/**
 * ID生成工具-雪花算法
 * Created at 2021/3/13 12:39
 *
 * @version 1.0
 * @author: DingJiaQi
 */
public class SnowFlakeFactory {
    /**
     * 起始的时间戳
     */
    private final static long START_TIME = 1480166465631L;

    /**
     * 每一部分占用的位数
     */
    private final static long SEQUENCE_BIT = 12; //序列号占用的位数
    private final static long MACHINE_BIT = 5;   //机器标识占用的位数
    private final static long DATACENTER_BIT = 5;//数据中心占用的位数

    /**
     * 每一部分的最大值
     */
    private final static long MAX_DATACENTER_NUM = ~(-1L << DATACENTER_BIT);
    private final static long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);

    /**
     * 每一部分向左的位移
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    private long datacenterId;  //数据中心
    private long machineId;     //机器标识
    private long sequence = 0L; //序列号
    private long lastSTMP = -1L;//上一次时间戳

    private SnowFlakeFactory() {}

    /**
     * 创建唯一的ID工厂
     * @param datacenterId 数据中心标识
     * @param machineId 机器标识
     */
    private SnowFlakeFactory(long datacenterId, long machineId) {
        if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    /**
     * 产生下一个ID
     *
     * @return 整型ID
     */
    private synchronized long nextID() {
        // 当前时间戳
        long currSTMP = getNewSTMP();
        if (currSTMP < lastSTMP) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currSTMP == lastSTMP) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currSTMP = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }

        lastSTMP = currSTMP;

        return (currSTMP - START_TIME) << TIMESTMP_LEFT //时间戳部分
                | datacenterId << DATACENTER_LEFT       //数据中心部分
                | machineId << MACHINE_LEFT             //机器标识部分
                | sequence;                             //序列号部分
    }

    private long getNextMill() {
        long mill = getNewSTMP();
        while (mill <= lastSTMP) {
            mill = getNewSTMP();
        }
        return mill;
    }

    /**
     * 获取最新时间戳
     * @return 毫秒数
     */
    private long getNewSTMP() {
        return System.currentTimeMillis();
    }

    // 实例
    private static SnowFlakeFactory factory;

    /**
     * 生成ID
     * @return 字符串ID
     */
    public static String generateID() {
        if (factory == null) {
            factory = new SnowFlakeFactory(1, 1);
        }
        return String.valueOf(factory.nextID());
    }

    public static void main(String[] args) {
/*
        SnowFlakeFactory snowFlake = new SnowFlakeFactory(2, 3);
*/
        for (int i = 0; i < (1 << 12); i++) {
            System.out.println(generateID());
        }

    }
}
