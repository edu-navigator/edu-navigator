package org.edunavigator.database_lib.repository;
import org.edunavigator.database_lib.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolEntity,String> {
}
