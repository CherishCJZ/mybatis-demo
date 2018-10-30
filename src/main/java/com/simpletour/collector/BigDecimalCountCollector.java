package com.simpletour.collector;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author: chenjunzhou
 * @date: 2018/10/29
 */
public class BigDecimalCountCollector implements Collector<BigDecimal, List<BigDecimal>, BigDecimal> {

    private final int scale;
    private final RoundingMode mode;

    public BigDecimalCountCollector(int scale, RoundingMode mode) {
        this.scale = scale;
        this.mode = mode;
    }

    public BigDecimalCountCollector(int scale) {
        this(scale, RoundingMode.HALF_UP);
    }

    public BigDecimalCountCollector() {
        this(2, RoundingMode.HALF_UP);
    }

    @Override
    public Supplier<List<BigDecimal>> supplier() {
        return Lists::newArrayList;
    }

    @Override
    public BiConsumer<List<BigDecimal>, BigDecimal> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<BigDecimal>> combiner() {
        return (preList, postList) -> {
            preList.addAll(postList);
            return preList;
        };
    }

    @Override
    public Function<List<BigDecimal>, BigDecimal> finisher() {
        return list -> {
            final BigDecimal[] result = {new BigDecimal(0)};
            list.forEach(d -> result[0] = result[0].add(d));
            return result[0].setScale(scale, mode);
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Sets.newHashSet(Characteristics.UNORDERED, Characteristics.CONCURRENT);
    }
}
