package com.pofy.chqty.service.common;

/**
 * function - 邮件服务接口
 *
 * @author POFY
 * @version 1.0
 * @date 2018-06-04
 **/
public interface MailService {

    /**
     * function - 发送文本邮件
     * @param to 目标地址
     * @param subject 主题
     * @param content  内容
     */
    void sendSimpleMail(String to, String subject, String content);

    /**
     * function - 发送html邮件
     * @param to 目标地址
     * @param subject 主题
     * @param content  内容
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * function - 发送带附件的邮件
     * @param to 目标地址
     * @param subject 主题
     * @param content  内容
     * @param filePath 文件路径
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath);

    /**
     * function - 发送正文中有静态资源（图片）的邮件
     * @param to 目标地址
     * @param subject 主题
     * @param content  内容
     * @param rscPath 资源路径
     * @param rscId 资源id
     */
    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);

}