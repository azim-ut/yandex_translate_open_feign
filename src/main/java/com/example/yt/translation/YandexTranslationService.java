package com.example.yt.translation;

import com.example.yt.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class YandexTranslationService implements TranslationService {

    private final YandexRemoteClient yandexRemoteClient;

    @Override
    public List<String> translate(String fromLang, String toLang, String data) {
        return yandexRemoteClient
                .fetchTranslate(new YandexRequest.Request(fromLang, toLang, List.of(data)))
                .translations()
                .stream()
                .map(YandexResponse.ResponseRow::text)
                .collect(Collectors.toList());
    }
}
