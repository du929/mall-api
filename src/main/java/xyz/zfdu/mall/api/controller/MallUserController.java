package xyz.zfdu.mall.api.controller;

/**
 * @author zfdu
 * @description MallUserController
 * @data 2021-04-21
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import xyz.zfdu.mall.api.common.Constants;
import xyz.zfdu.mall.api.common.ServiceResultEnum;
import xyz.zfdu.mall.api.config.annotation.TokenToMallUser;
import xyz.zfdu.mall.api.controller.param.MallUserLoginParam;
import xyz.zfdu.mall.api.controller.param.MallUserRegisterParam;
import xyz.zfdu.mall.api.controller.param.MallUserUpdateParam;
import xyz.zfdu.mall.api.controller.vo.MallUserVO;
import xyz.zfdu.mall.api.entity.MallUser;
import xyz.zfdu.mall.api.service.MallUserService;
import xyz.zfdu.mall.api.util.BaseBeanUtil;
import xyz.zfdu.mall.api.util.NumberUtil;
import xyz.zfdu.mall.api.util.Result;
import xyz.zfdu.mall.api.util.ResultGenerator;
import javax.annotation.Resource;
import javax.validation.Valid;


@RestController
@Api(value = "v1", tags = "1.楼楼商城用户操作相关接口")
@RequestMapping("/api/v1")
@Slf4j
public class MallUserController {
    @Resource
    private MallUserService mallUserService;

    @PostMapping("/user/login")
    @ApiOperation(value = "登录接口", notes = "返回token")
    public Result<String> login(@RequestBody @Valid MallUserLoginParam mallUserLoginParam) {
        if (!NumberUtil.isPhone(mallUserLoginParam.getLoginName())) {
            return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_NAME_IS_NOT_PHONE.getResult());

        }
        String loginResult = mallUserService.login(mallUserLoginParam.getLoginName(),
                mallUserLoginParam.getPasswordMd5());
        log.info("login api,loginName={},loginResult={}",
                mallUserLoginParam.getLoginName(), loginResult);
        //登录成功
        if (!StringUtils.isEmpty(loginResult) && loginResult.length() == Constants.TOKEN_LENGTH) {
            Result result = ResultGenerator.genSuccessResult();
            result.setData(loginResult);
            return result;
        }
        //登录失败
        return ResultGenerator.genFailResult(loginResult);
    }

    @PostMapping("/user/logout")
    @ApiOperation(value = "登出接口", notes = "清除token")
    public Result<String> logout(@TokenToMallUser MallUser loginMallUser) {
        Boolean logoutResult = mallUserService.logout(loginMallUser.getUserId());
        log.info("logout api,loginMallUser={}", loginMallUser.getUserId());
        //登出成功
        if (logoutResult) {
            return ResultGenerator.genSuccessResult();
        }
        //登出失败
        return ResultGenerator.genFailResult("logout error");
    }

    @PostMapping("/user/register")
    @ApiOperation(value = "用户注册", notes = "")
    public Result register(@RequestBody @Valid MallUserRegisterParam mallUserRegisterParam) {
        if (!NumberUtil.isPhone(mallUserRegisterParam.getLoginName())) {
            return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_NAME_IS_NOT_PHONE.getResult());

        }
        String registerResult = mallUserService.register(mallUserRegisterParam.getLoginName(),
                mallUserRegisterParam.getPassword());
        log.info("register api,loginName={},loginResult={}", mallUserRegisterParam.getLoginName(), registerResult);
        //注册成功
        if (ServiceResultEnum.SUCCESS.getResult().equals(registerResult)) {
            return ResultGenerator.genSuccessResult();
        }
        //注册失败
        return ResultGenerator.genFailResult(registerResult);
    }
    @PutMapping("/user/info")
    @ApiOperation(value = "修改用户信息", notes = "")
    public Result updateInfo(@RequestBody @ApiParam("用户信息") MallUserUpdateParam mallUserUpdateParam, @TokenToMallUser MallUser loginMallUser) {
        Boolean flag = mallUserService.updateUserInfo(mallUserUpdateParam,
                loginMallUser.getUserId());
        if (flag) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }
    @GetMapping("/user/info")
    @ApiOperation(value = "获取用户信息", notes = "")
    public Result<MallUserVO> getUserDetail(@TokenToMallUser MallUser loginMallUser) {
        //已登录则直接返回
        MallUserVO mallUserVO = new MallUserVO();
        BaseBeanUtil.copyProperties(loginMallUser, mallUserVO);
        return ResultGenerator.genSuccessResult(mallUserVO);
    }
    }
