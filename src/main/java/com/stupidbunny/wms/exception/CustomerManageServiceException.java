package com.stupidbunny.wms.exception;

/**
 * CustomerManageService异常
 *
 * @author Stupidbunny
 * @since 2017/3/8.
 */
public class CustomerManageServiceException extends BusinessException{

    public CustomerManageServiceException(){
        super();
    }

    public CustomerManageServiceException(Exception e, String exception){
        super(e, exception);
    }

    public CustomerManageServiceException(Exception e){
        super(e);
    }
}
