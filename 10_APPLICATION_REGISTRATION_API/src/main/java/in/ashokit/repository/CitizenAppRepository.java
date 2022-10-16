package in.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.CitizenEntity;

@Repository
public interface CitizenAppRepository extends JpaRepository<CitizenEntity, Serializable> {

}
