package com.yishui.yishuiojcodesandbox.security;


import java.security.Permission;

/**
 * 默认安全管理器
 */
public class MySecurityManager extends SecurityManager {

    /**
     * 检查所有的权限
     * @param perm   the requested permission.
     */
    @Override
    public void checkPermission(Permission perm) {
//        super.checkPermission(perm);

    }

    /**
     * 检测程序是否可执行文件
     * @param cmd   the specified system command.
     */
    @Override
    public void checkExec(String cmd) {
        throw new SecurityException("checkExec 权限异常" + cmd);
    }

    /**
     * 检测程序是否允许读取文件
     * @param file      the system-dependent filename.
     * @param context   a system-dependent security context.
     */
    @Override
    public void checkRead(String file, Object context) {
        throw new SecurityException("checkRead 权限异常" + file);
    }

    /**
     *
     * 检测程序是否允许写入文件
     * @param file   the system-dependent filename.
     */
    @Override
    public void checkWrite(String file) {
        throw new SecurityException("checkWrite 权限异常" + file);
    }

    /**
     * 检测程序是否允许删除文件
     * @param file   the system-dependent filename.
     */
    @Override
    public void checkDelete(String file) {
        throw new SecurityException("checkDelete 权限异常" + file);
    }

    /**
     * 检测程序是否允许连接到指定主机的指定端口
     * @param host   the host name port to connect to.
     * @param port   the protocol port to connect to.
     */
    @Override
    public void checkConnect(String host, int port) {
        throw new SecurityException("checkConnect 权限异常" + host + ":" + port);
    }


}
