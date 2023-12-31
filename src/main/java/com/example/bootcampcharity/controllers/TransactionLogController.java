package com.example.bootcampcharity.controllers;

import com.example.bootcampcharity.models.dtoes.TransactionLogDto;
import com.example.bootcampcharity.models.entities.TransactionLogEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactionlog")
@Transactional(readOnly = true)
public class TransactionLogController extends BaseController<TransactionLogEntity, TransactionLogDto,Long>{
}
