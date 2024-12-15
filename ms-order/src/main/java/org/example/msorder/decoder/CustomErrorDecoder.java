package org.example.msorder.decoder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.example.msorder.exception.CustomFeignClientException;

import static org.example.msorder.decoder.JsonNodeFieldNames.CODE;
import static org.example.msorder.decoder.JsonNodeFieldNames.MESSAGE;
import static org.example.msorder.exception.ErrorConstants.CLIENT_ERROR;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        var errorMessage = CLIENT_ERROR.getMessage();
        var errorCode = CLIENT_ERROR.getCode();
        JsonNode jsonNode;
        try(var body = response.body().asInputStream()) {
            jsonNode = new ObjectMapper().readValue(body, JsonNode.class);
        }catch (Exception e) {
            throw new CustomFeignClientException(CLIENT_ERROR.getMessage(), errorCode, response.status());
        }
        if (jsonNode.has(MESSAGE)) {
            errorMessage = jsonNode.get(MESSAGE).asText();
        }
        if (jsonNode.has(CODE)) {
            errorCode = jsonNode.get(CODE).asText();
        }

    log.error("Action.Log.decode.error Message:{}, Method:{}", errorMessage, methodKey);
        return new CustomFeignClientException(errorMessage, errorCode, response.status());
    }
}
