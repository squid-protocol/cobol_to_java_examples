package com.gitgalaxy.modernized.dto.screen;

/**
 * One positioned piece of a rendered screen (#3619): a label, an output field or an input box.
 * `key` is the form key of an input (the property name, `name.n` for the n-th occurrence), else null;
 * `line` is 1-based, `column` the 0-based column the data starts in; `css` the classes that style it.
 */
public record ScreenCell(String key, int line, int column, int length, boolean input, String text, String css,
                         boolean cursor) {
}
