package com.pet.userManage.controller;

import com.pet.models.AdoptApplication;
import com.pet.models.FindApplication;
import com.pet.models.ReportApplication;
import com.pet.models.SendApplication;
import com.pet.userManage.entity.AdoptBriefInfo;
import com.pet.userManage.entity.FindBriefInfo;
import com.pet.userManage.entity.ReportBriefInfo;
import com.pet.userManage.entity.SendBriefInfo;
import com.pet.userManage.service.AdoptApplicationService;
import com.pet.userManage.service.FindApplicationService;
import com.pet.userManage.service.ReportApplicationService;
import com.pet.userManage.service.SendApplicationService;
import com.pet.util.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("api/history")
@RefreshScope
@Api(value="get_history",tags = "获取所有申请表历史")
public class HistoryController {
    private AdoptApplicationService adopt;
    private FindApplicationService find;
    private SendApplicationService send;
    private ReportApplicationService report;

    @Autowired
    public void setAdopt(AdoptApplicationService adopt){
        this.adopt = adopt;
    }
    @Autowired
    public void setFind(FindApplicationService find){
        this.find = find;
    }
    @Autowired
    public void setSend(SendApplicationService send){
        this.send = send;
    }
    @Autowired
    public void setReport(ReportApplicationService report){
        this.report = report;
    }

    @ApiOperation(value = "获取领养表历史")
    @RequestMapping(value = "/adopt",method = RequestMethod.GET)
    public Result<List<AdoptBriefInfo>>getAdoptList(@RequestParam("userID") String userID){
        List<AdoptApplication> adoptList = adopt.findALLByUserID(userID);
        List<AdoptBriefInfo> adoptBriefInfos = new LinkedList<>();
        for (AdoptApplication adoptApplication : adoptList) {
            adoptBriefInfos.add(new AdoptBriefInfo(adoptApplication));
        }
        return Result.wrapSuccessfulResult(adoptBriefInfos);
    }

    @ApiOperation(value = "获取寻回表历史")
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public Result<List<FindBriefInfo>>getFindList(@RequestParam("userID") String userID){
        List<FindApplication> findList = find.findALLByUserID(userID);
        List<FindBriefInfo> findBriefInfos = new LinkedList<>();
        for (FindApplication findApplication : findList) {
            findBriefInfos.add(new FindBriefInfo(findApplication));
        }
        return Result.wrapSuccessfulResult(findBriefInfos);
    }

    @ApiOperation(value = "获取上报表历史")
    @RequestMapping(value = "/report",method = RequestMethod.GET)
    public Result<List<ReportBriefInfo>>getReportList(@RequestParam("userID") String userID){
        List<ReportApplication> reportList = report.findALLByUserID(userID);
        List<ReportBriefInfo> reportBriefInfos = new LinkedList<>();
        for (ReportApplication reportApplication : reportList) {
            reportBriefInfos.add(new ReportBriefInfo(reportApplication));
        }
        return Result.wrapSuccessfulResult(reportBriefInfos);
    }

    @ApiOperation(value = "获取送养表历史")
    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public Result<List<SendBriefInfo>>getSendList(@RequestParam("userID") String userID){
        List<SendApplication> sendList = send.findALLByUserID(userID);
        List<SendBriefInfo> sendBriefInfos = new LinkedList<>();
        for (SendApplication sendApplication : sendList) {
            sendBriefInfos.add(new SendBriefInfo(sendApplication));
        }
        return Result.wrapSuccessfulResult(sendBriefInfos);
    }
}
