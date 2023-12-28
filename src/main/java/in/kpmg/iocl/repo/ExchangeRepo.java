package in.kpmg.iocl.repo;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.kpmg.iocl.entity.ExchangeEntity;


@Repository
public interface ExchangeRepo extends JpaRepository<ExchangeEntity, Long> {

    @Query(value = "SELECT exd FROM ExchangeEntity exd WHERE exd.fcurr = :from_currency AND exd.tcurr = :to_currency and exd.kurst = :exchange_type and exd.gdatu = :effective_date")
    public List<ExchangeEntity> fetchExchangeData(
            @Param("from_currency") String from_currency,
            @Param("to_currency") String to_currency,
            @Param("exchange_type") String exchange_type,
            @Param("effective_date") String effective_date
    );

}
