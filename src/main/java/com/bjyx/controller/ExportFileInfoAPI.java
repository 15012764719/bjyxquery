package com.bjyx.controller;

import com.bjyx.entity.TbExportInfo;
import com.bjyx.entity.TbUserInfo;
import com.bjyx.mapper.TbExportInfoMapper;
import com.bjyx.mapper.TbUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ExportFileInfoAPI {

    @Autowired(required = false)
    private TbExportInfoMapper tbExportInfoMapper;

    @Autowired(required = false)
    private TbUserInfoMapper tbuserInfoMapper;

    @PostMapping("/getList")
    public String getList(TbUserInfo tbUserInfo, Model model) {

//        PageHelper.startPage(queryVo.getPage(), queryVo.getLimit());

        List<TbExportInfo> tbExportInfos = tbExportInfoMapper.selectByUserId(tbUserInfo.getId());
        tbUserInfo = tbuserInfoMapper.selectByPrimaryKey(tbUserInfo.getId());
        model.addAttribute("exportInfos", tbExportInfos);
//        session.setAttribute(Constants.SESSION_KEY, tbUserInfo);
//        Page<Article> articles = articleService.findWithBLOBsByPage(pageNum, pageSize);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
//        PageInfo<Article> pageInfo = new PageInfo<>(articles);

//        return new SysResult(1, "",tbExportInfos);
        return "list";

    }
}
