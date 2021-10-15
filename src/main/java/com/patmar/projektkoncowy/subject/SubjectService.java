package com.patmar.projektkoncowy.subject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import static com.patmar.projektkoncowy.subject.SubjectMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private SubjectRepository repository;

    public void addSubject (SubjectCreateRequest request) {
        Subject subject = MAPPER.toSubject(request);
        repository.save(subject);
    }

    public void updateSubject (Subject subject) {
        repository.save(subject);
    }
    public List<SubjectView> findAll() {
        return repository.findAll()
                .stream()
                .map(MAPPER::toSubjectListView)
                .collect(Collectors.toList());
    }
    public void deleteSubject (Subject subject) {

        repository.delete(subject);
    }
    public List<SubjectView> getSubject(Long id) {
        return repository.findById(id)
                .stream()
                .map(MAPPER::toSubjectSingleView)
                .collect(Collectors.toList());
    }
}
