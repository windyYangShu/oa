package cn.uestc.oa.entity;

/**
 * 正如在员工表中描述的一样部门和员工之间是一对多的关系但在这里却没有与员工表相连接
 * 这就是数据库中不设置外键的好处，在表中只使用逻辑外键，并且在实际应用中也没有根据部门查询出所有员工的需求
 * 因此这里就没有使用一个list集合用来保存所有员工的信息，如果在表中使用了外键，那么这里就要必须写上了
 */

public class Department {

    private String sn;

    private String name;

    private String address;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}