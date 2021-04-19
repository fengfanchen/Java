package cn.it1995.object;

import javax.persistence.*;

@Entity
@Table(name = "test_demo", schema = "TESTDB", catalog = "")
public class TestDemo {
    private long id;
    private String value1;
    private Integer value2;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "value_1")
    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    @Basic
    @Column(name = "value_2")
    public Integer getValue2() {
        return value2;
    }

    public void setValue2(Integer value2) {
        this.value2 = value2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestDemo testDemo = (TestDemo) o;

        if (id != testDemo.id) return false;
        if (value1 != null ? !value1.equals(testDemo.value1) : testDemo.value1 != null) return false;
        if (value2 != null ? !value2.equals(testDemo.value2) : testDemo.value2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (value1 != null ? value1.hashCode() : 0);
        result = 31 * result + (value2 != null ? value2.hashCode() : 0);
        return result;
    }
}
