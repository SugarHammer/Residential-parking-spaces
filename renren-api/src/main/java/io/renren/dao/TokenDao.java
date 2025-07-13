/**
 * .
 *
 *
 *
 *
 */

package io.renren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.entity.TokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Token
 *
 *
 */
@Mapper
public interface TokenDao extends BaseMapper<TokenEntity> {
	
}
