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

    public void createRecordLabel(RecordLabels recordLabels) {
        recordLabelRepository.createRecordLabel(recordLabels);
    }

    public RecordLabels findRecordLabel(Long id) {
        return recordLabelRepository.findRecordLabel(id);
    }

    public void updateRecordLabelName(Long id, String name) {
        recordLabelRepository.updateRecordLabelName(id, name);
    }

    public void deleteRecordLabel(Long id) {
        recordLabelRepository.deleteRecordLabel(id);

    }
}

