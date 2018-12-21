package com.pass.cloud.mdc.web.frontend;

import com.pass.cloud.core.support.BaseController;
import com.pass.cloud.mdc.model.domain.MdcDict;
import com.pass.cloud.mdc.model.dto.MdcDictCheckCodeDto;
import com.pass.cloud.mdc.model.dto.MdcDictCheckNameDto;
import com.pass.cloud.mdc.service.MdcDictService;
import com.pass.cloud.wrapper.WrapMapper;
import com.pass.cloud.wrapper.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

/**
 * @author takesi
 */
@RestController
@RequestMapping(value = "/dict", produces = MediaType.APPLICATION_JSON_VALUE)
public class UacDictCommonController extends BaseController {

    @Autowired
    private MdcDictService mdcDictService;

    /**
     * 检测菜单编码是否已存在
     *
     * @param mdcDictCheckCodeDto the mdc dict check code dto
     * @return the wrapper
     */
    @RequestMapping(value = "/checkDictCode", method = RequestMethod.OPTIONS)
    public Wrapper<Boolean> checkDictCode(@RequestBody MdcDictCheckCodeDto mdcDictCheckCodeDto) {
        logger.info("检测数据字典编码是否已存在 mdcDictCheckCodeDto={}", mdcDictCheckCodeDto);

        Long id = mdcDictCheckCodeDto.getDictId();
        String dictCode = mdcDictCheckCodeDto.getDictCode();

        Example example = new Example(MdcDict.class);
        Example.Criteria criteria = example.createCriteria();

        if (id != null) {
            criteria.andNotEqualTo("id", id);
        }
        criteria.andEqualTo("dictCode", dictCode);

        int result = mdcDictService.selectCountByExample(example);
        return WrapMapper.ok(result < 1);
    }

    /**
     * 检测数据字典名称是否已存在.
     *
     * @param mdcDictCheckNameDto the mdc dict check name dto
     * @return the wrapper
     */
    @RequestMapping(value = "/checkDictName", method = RequestMethod.OPTIONS)
    public Wrapper<Boolean> checkDictName(@RequestBody MdcDictCheckNameDto mdcDictCheckNameDto) {
        logger.info("检测数据字典名称是否已存在 mdcDictCheckNameDto={}", mdcDictCheckNameDto);

        Long id = mdcDictCheckNameDto.getDictId();
        String dictName = mdcDictCheckNameDto.getDictName();

        Example example = new Example(MdcDict.class);
        Example.Criteria criteria = example.createCriteria();

        if (id != null) {
            criteria.andNotEqualTo("id", id);
        }
        criteria.andEqualTo("dictName", dictName);

        int result = mdcDictService.selectCountByExample(example);
        return WrapMapper.ok(result < 1);
    }

}
