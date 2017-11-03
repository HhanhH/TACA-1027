package com.taca.service;

import java.util.Set;

/**
 * Created by 芳华 on 2017/9/26.
 */
public interface TaskMutexService {
    Set<Long> getMutexTaskIdList(Long id);
}
