package repository;

import entity.account.Transfer;
import org.apache.ibatis.annotations.Param;

/**
 * Created by jxilong on 2017/7/22.
 */
public interface TransferRepository {

    Transfer lockByBizNo(@Param("bizNo") String bizNo);

    void update(Transfer transfer);
}
