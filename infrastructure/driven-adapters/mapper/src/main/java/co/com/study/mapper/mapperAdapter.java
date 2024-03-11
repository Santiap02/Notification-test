package co.com.study.mapper;

import co.com.study.model.helper.MapperRepository;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class mapperAdapter implements MapperRepository {

    private final ObjectMapper mapper;

    private final com.fasterxml.jackson.databind.ObjectMapper jacksonMapper;

    @Override
    public <T> T map(Object src, Class<T> target) {
        return mapper.map(src, target);
    }

    @Override
    public <T> T jacksonMap(Object src, Class<T> target) {
        return jacksonMapper.convertValue(src, target);
    }

}
