package uz.mirkamol.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepo extends JpaRepository<Hello, Long> {
}
