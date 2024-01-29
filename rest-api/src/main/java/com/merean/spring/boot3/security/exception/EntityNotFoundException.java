/**
 * File Name        	: EntityNotFoundException.java
 * File Path        	: bnk-core-api/src/main/java/com/bnkcmfi/api/exception/EntityNotFoundException.java
 * File Description 	: EntityNotFoundException
 * File Author	  		:
 * Created Date	  	    : 05-August-2020 09:00 AM
 * Developed By	  	    :
 * Modified Date	  	:
 * Modified By          :
 **/
package com.merean.spring.boot3.security.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 *  Handle exception entity not found
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

    public <T> EntityNotFoundException(Class<T> clazz, String... searchParamsMap) {

        super(generateMessage(clazz.getSimpleName(), toMap(String.class, String.class, searchParamsMap)));

    }

    private static String generateMessage(String entity, Map<String, String> searchParams) {

        return StringUtils.capitalize(entity) +
                " was not found for parameters " +
                searchParams;

    }

    private static <K, V> Map<K, V> toMap(
            Class<K> keyType, Class<V> valueType, String... entries) {

        if (entries.length % 2 == 1)
            throw new IllegalArgumentException("Invalid entries");

        return IntStream.range(0, entries.length / 2).map(i -> i * 2)
                .collect(HashMap::new,
                        (m, i) -> m.put(keyType.cast(entries[i]), valueType.cast(entries[i + 1])),
                        Map::putAll);

    }

}
