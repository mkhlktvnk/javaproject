package com.example.javaproject.services;
import com.example.javaproject.cache.calculation.CalculationCache;
import com.example.javaproject.entity.params.CalculationParams;
import org.springframework.beans.factory.annotation.Autowired;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    private static final Logger logger = LogManager.getLogger(CalculatorService.class);

    private Double mathFunction(Double x) {
        return Math.sin(x);
    }

    public Double performCalculation(CalculationParams calculationParams) {
        int n = 100;
        Double h = (calculationParams.getHighValue() - calculationParams.getLowValue()) / 2;
        Double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 2 * mathFunction(calculationParams.getLowValue() + i * h);
        }
        sum *= h / 2;
        return sum;
    }
}
