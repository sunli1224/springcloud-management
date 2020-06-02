package basemapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author sunli
 * @date 2020/2/13 3:42
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
