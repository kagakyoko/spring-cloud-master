package com.pass.cloud.uac.web.admin;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pass.cloud.core.support.BaseController;
import com.pass.cloud.uac.model.dto.action.ActionMainQueryDto;
import com.pass.cloud.uac.model.vo.ActionVo;
import com.pass.cloud.uac.service.UacActionService;
import com.pass.cloud.wrapper.WrapMapper;
import com.pass.cloud.wrapper.Wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author takesi
 */
@RestController
@RequestMapping(value = "/action")
public class UacActionRestController extends BaseController {

    @Autowired
    private UacActionService uacActionService;

    /**
     * 分页查询角色信息.
     *
     * @param action the action
     * @return the wrapper
     */
    @GetMapping(value = "/queryListWithPage", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper<PageInfo> queryUacActionListWithPage(ActionMainQueryDto action) {
        PageInfo<ActionVo> pageInfo = uacActionService.queryActionListWithPage(action);
        return WrapMapper.ok(pageInfo);
    }

    /**
     * 删除角色信息.
     *
     * @param id the id
     * @return the wrapper
     */
    @DeleteMapping(value = "/deleteActionById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper deleteUacActionById(@PathVariable Long id) {
        int result = uacActionService.deleteActionById(id);
        return super.handleResult(result);
    }

    /**
     * 批量删除角色.
     *
     * @param deleteIdList the delete id list
     * @return the wrapper
     */
    @DeleteMapping(value = "/batchDeleteByIdList", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper batchDeleteByIdList(@RequestBody List<Long> deleteIdList) {
        uacActionService.batchDeleteByIdList(deleteIdList);
        return WrapMapper.ok();
    }

}
