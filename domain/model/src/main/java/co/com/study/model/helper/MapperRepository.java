package co.com.study.model.helper;

public interface MapperRepository {

    <T> T map(Object src, Class<T> target);

    <T> T jacksonMap(Object src, Class<T> target);
}
