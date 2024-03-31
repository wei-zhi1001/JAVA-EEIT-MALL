package com.willy.malltest.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class EmailController {
    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    private final EmailService emailService;
    // 使用 ConcurrentHashMap 作为验证码的临时存储
    private final Map<String, String> verificationCodes = new ConcurrentHashMap<>();

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/register")
    public Result register(@RequestBody Map<String, String> requestBody) {
        String email = ""; // 或者 null
        try {
            email = requestBody.get("email");
            logger.info("Received email: {}", email);

            // 生成验证码
            String code = Utils.generateVerificationCode();
            logger.info("Generated code: {}", code);
            // 将验证码存储到内存中
            verificationCodes.put(email, code);

            // 假设验证码在5分钟后过期（这里仅为日志记录，实际没有自动过期处理）
            logger.info("Setting verification code for: {}. Code will expire in 5 minutes.", email);

            // 发送注册邮件
            emailService.sendSimpleMessage(email, "注册验证码", "您的验证码是：" + code);
            logger.info("Verification code sent to: {}", email);
            return new Result(Result.SUCCESS, "验证码已发送至您的邮箱");
        } catch (Exception e) {
            logger.error("Failed to send email to: {} with error:", email, e);
            return new Result(Result.ERROR, "发送验证码失败");
        }
    }
}
