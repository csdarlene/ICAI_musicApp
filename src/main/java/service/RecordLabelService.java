package service;

import configuration.JPAConfiguration;
import entity.RecordLabels;
import repository.RecordLabelRepository;

import java.util.List;

public class RecordLabelService {
    private final RecordLabelRepository recordLabelRepository;

    public RecordLabelService() {
        this.recordLabelRepository = new RecordLabelRepository(JPAConfiguration.getEntityManager());
    }

    public List<RecordLabels> getAllRecordLabels() {
        return recordLabelRepository.getAllRecordLabels();
    }

    public RecordLabels createRecordLabel(RecordLabels recordLabels) {
        return recordLabelRepository.createRecordLabel(recordLabels);
    }

    public RecordLabels findRecordLabel(Long id) {
        return recordLabelRepository.findRecordLabel(id);
    }

    public RecordLabels updateRecordLabelName(Long id, String name) {
        return recordLabelRepository.updateRecordLabelName(id, name);
    }

    public RecordLabels deleteRecordLabel(Long id) {
        return recordLabelRepository.deleteRecordLabel(id);

    }
}

