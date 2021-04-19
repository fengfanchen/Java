package cn.it1995.repository;

import cn.it1995.object.TestDemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDemoRepository extends JpaRepository<TestDemo, Long> {
}
