package com.stupidbunny.wms.exception;

/**
 * StorageManageServiceException异常
 *
 * @author Stupidbunny
 * @since 2017/3/8.
 */
public class StorageManageServiceException extends BusinessException {

    StorageManageServiceException(){
        super();
    }

    public StorageManageServiceException(Exception e){
        super(e);
    }

    StorageManageServiceException(Exception e, String exceptionDesc){
        super(e, exceptionDesc);
    }

}
