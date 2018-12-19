package com.pass.cloud.mdc.web.frontend;

import java.util.List;

import com.pass.cloud.base.dto.LoginAuthDto;
import com.pass.cloud.base.dto.UpdateStatusDto;
import com.pass.cloud.core.support.BaseController;
import com.pass.cloud.mdc.model.domain.MdcDict;
import com.pass.cloud.mdc.model.dto.MdcEditDictDto;
import com.pass.cloud.mdc.model.vo.MdcDictVo;
import com.pass.cloud.mdc.service.MdcDictService;
import com.pass.cloud.wrapper.WrapMapper;
import com.pass.cloud.wrapper.Wrapper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author takesi
 */
@RestController
@RequestMapping(value = "/dict")
public class MdcDictRestController extends BaseController {

    @Autowired
    private MdcDictService mdcDictService;

    /**
     * 获取字典列表数据
     *
     * @return the wrapper
     */
    @GetMapping(value = "/getTree", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper<List> queryDictTreeList() {
        List<MdcDictVo> dictVoList = mdcDictService.getDictTreeList();
        return WrapMapper.ok(dictVoList);
    }

    /**
     * 根据ID获取字典信息.
     *
     * @param id the id
     * @return the wrapper
     */
    @GetMapping(value = "/queryById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper<MdcDictVo> queryDictVoById(@PathVariable Long id) {
        MdcDictVo mdcDictVo = mdcDictService.getMdcDictVoById(id);
        return WrapMapper.ok(mdcDictVo);
    }

    /**
     * 根据id修改字典的禁用状态
     *
     * @return the wrapper
     */
    @PatchMapping(value = "/modifyStatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper updateMdcDictStatusById(@RequestBody UpdateStatusDto updateStatusDto) {
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        mdcDictService.updateMdcDictStatusById(updateStatusDto, loginAuthDto);
        return WrapMapper.ok();
    }

    @PutMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper saveDict(@RequestBody MdcEditDictDto mdcDictAddDto) {
        MdcDict mdcDict = new MdcDict();
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        BeanUtils.copyProperties(mdcDictAddDto, mdcDict);
        mdcDictService.saveMdcDict(mdcDict, loginAuthDto);
        return WrapMapper.ok();
    }

    /**
     * 根据id删除字典
     *
     * @param id the id
     * @return the wrapper
     */
    @DeleteMapping(value = "/deleteById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wrapper<Integer> deleteMdcDictById(@PathVariable Long id) {
        // 判断此字典是否有子节点
        boolean hasChild = mdcDictService.checkDictHasChildDict(id);
        if (hasChild) {
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "此字典含有子字典, 请先删除子字典");
        }

        int result = mdcDictService.deleteByKey(id);
        return super.handleResult(result);
    }

}
