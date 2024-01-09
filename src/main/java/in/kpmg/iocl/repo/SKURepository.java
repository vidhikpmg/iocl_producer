package in.kpmg.iocl.repo;

import in.kpmg.iocl.entity.SKUModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SKURepository extends JpaRepository<SKUModel,Long> {
    @Query(value= "Select * from yv_material_master_all_views_e_marm sac WHERE sac.mantr= :materialNo AND sac.meinh= :baseUnitOfMeasure AND sac.meins= :unitOfMeasureDisplay AND sac.UMREN= :denominatorConversion AND sac.umrez= :numeratorConversion", nativeQuery = true)
    public List<SKUModel> getSKUData(
    @Param("materialNo") String materialNo,
    @Param("baseUnitOfMeasure") String baseUnitOfMeasure,
    @Param("unitOfMeasureDisplay") String unitOfMeasureDisplay,
    @Param("numeratorConversion") String numeratorConversion,
    @Param("denominatorConversion") String denominatorConversion
);
}









