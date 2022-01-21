package com.stupidbunny.wms.exception;

/**
 * GoodsManageService异常
 *
 * @author Stupidbunny
 * @since 2017/3/8.
 */
public class GoodsManageServiceException extends BusinessException {

    GoodsManageServiceException(){
        super();
    }

    public GoodsManageServiceException(Exception e){
        super(e);
    }

    GoodsManageServiceException(Exception e, String exceptionDesc){
        super(e, exceptionDesc);
    }

}
