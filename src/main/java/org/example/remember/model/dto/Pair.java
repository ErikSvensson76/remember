package org.example.remember.model.dto;

import java.io.Serializable;

public record Pair<K, V>(K key, V value) implements Serializable {}
