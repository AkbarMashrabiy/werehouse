package uz.pdp.werehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.werehouse.model.entity.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, String> {


}
