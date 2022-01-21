package com.stupidbunny.wms.exception;

/**
 * StockRecordManageService异常
 *
 * @author Stupidbunny
 * @since 2017/3/8.
 */
public class StockRecordManageServiceException extends BusinessException {

    public StockRecordManageServiceException(){
        super();
    }

    public StockRecordManageServiceException(Exception e){
        super(e);
    }

    public StockRecordManageServiceException(Exception e, String exceptionDesc){
        super(e, exceptionDesc);
    }

    public StockRecordManageServiceException(String exceptionDesc){
        super(exceptionDesc);
    }

}
