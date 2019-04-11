/*
 * Copyright (C) 2019 joaovperin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.feevale.jpe.complexity.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Pascal Triangle
 *
 * @author joaovperin
 */
public class Triangle {

    /** A stack for each line of the triangle */
    private final Stack<List<Long>> stack;

    /**
     * Default constructor
     */
    public Triangle() {
        this.stack = new Stack<>();
        this.stack.push(Arrays.asList(1L));
    }

    /**
     * Adds a line to the triangle
     */
    public void addLine() {
        List<Long> line = this.stack.peek();
        ArrayList<Long> newLine = new ArrayList<>();
        newLine.add(1L);
        // Adds the sum of the elements to a new line on the stack
        for (int i = 0; i < line.size() - 1; i++) {
            long newElm = line.get(i) + line.get(i + 1);
            newLine.add(newElm);
        }
        newLine.add(1L);
        stack.push(newLine);
    }

    /**
     * Returns the stack
     *
     * @return Stack
     */
    public Stack<List<Long>> getStack() {
        return this.stack;
    }

    /**
     * Convert's to String so it can be printed
     *
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ArrayList<List<Long>> arrayList = new ArrayList<>(stack);
        arrayList.forEach(e -> {
            e.forEach(i -> sb.append(i).append(" "));
            sb.append("\n");
        });
        return sb.toString();
    }

}
