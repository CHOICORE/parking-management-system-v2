package me.choicore.samples.complex.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.choicore.samples.complex.domain.model.ReferenceContext;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class ReferenceContextLoader {
    private final ReferenceContextRepository referenceContextRepository;

    public ReferenceContext load() {
        // TODO: not implemented yet
        return null;
    }
}
