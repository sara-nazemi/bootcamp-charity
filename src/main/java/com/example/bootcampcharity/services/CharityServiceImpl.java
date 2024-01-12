package com.example.bootcampcharity.services;

import com.example.bootcampcharity.models.dtoes.DepositCharityInfoDto;
import com.example.bootcampcharity.models.dtoes.serviceCall.WalletServiceDto;
import com.example.bootcampcharity.models.entities.CharityEntity;
import com.example.bootcampcharity.models.entities.TransactionLogEntity;
import com.example.bootcampcharity.repositories.CharityRepository;
import com.example.bootcampcharity.services.mockServiceCall.WalletServiceCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CharityServiceImpl extends BaseServiceImpl<CharityEntity, Long> implements CharityService {

    @Autowired
    WalletServiceCall walletServiceCall;

    @Autowired
    private CharityRepository charityRepository;

    @Autowired
    private TransactionLogService transactionLogService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CharityServiceImpl.class);

    @Override
    protected JpaRepository<CharityEntity, Long> getRepository() {
        return charityRepository;
    }

    @Override
    public CharityEntity save(CharityEntity entity) {
        return charityRepository.save(entity);
    }

    @Override
    public CharityEntity findById(Long aLong) {
       return super.findById(aLong);
    }

    @Override
    public Boolean charity(DepositCharityInfoDto dto) {

       String userName = dto.getUserName();

        LOGGER.info("start get wallet");
        //دریافت اطلاعات ولت کاربر

        WalletServiceDto walletMock = walletServiceCall.getWalletMock(userName);

        LOGGER.info("get wallet");
        LOGGER.info("start get object of charity entity");
        //دریافت اطلاعات نیکوکاری

        CharityEntity byId = findById(dto.getCharityId());

        LOGGER.info("get object of charity entity");
        LOGGER.info("start withdraw of user wallet");
        //کم کردن پول از حساب کاربر

        WalletServiceDto walletServiceDto = walletServiceCall.withDrawWallet(walletMock.getId(), dto.getAmount());
        LOGGER.info("withdraw of user wallet");
        LOGGER.info("start deposit of user wallet");
        //اضافه کردن پول به حساب ولت نیکوکاری
        WalletServiceDto walletServiceDto1 = walletServiceCall.depositWallet(byId.getWalletId(), dto.getAmount());
        LOGGER.info("deposit of user wallet");

        //لاگ کردن عملیات تراکنش
        TransactionLogEntity transactionLogEntity = new TransactionLogEntity();
        transactionLogEntity.setCharity(byId);
        transactionLogEntity.setAmount(dto.getAmount());
        transactionLogEntity.setVersion(0);
        transactionLogEntity.setInsertDate(new Date());
        transactionLogEntity.setLastModifiedDate(new Date());

        TransactionLogEntity save = transactionLogService.save(transactionLogEntity);

        return Boolean.TRUE;
    }

    @Override
    public List<CharityEntity> findAll() {
        return super.findAll();
    }

    public void delete(Long id){
        super.deleteById(id);
    }
}
