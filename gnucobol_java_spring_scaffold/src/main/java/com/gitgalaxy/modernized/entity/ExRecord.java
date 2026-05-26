package com.gitgalaxy.modernized.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "EX_RECORD")
public class ExRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Long sysId;

    @Column(name = "OPCODE")
    private String opcode;

    @Column(name = "EX_FILENAME")
    private String exFilename;

    @Column(name = "EX_INDEX_NAME")
    private String exIndexName;

    @Column(name = "KEY2LENGTH")
    private Integer key2length;

    @Column(name = "KEY_VERSION")
    private Integer keyVersion;

    @Column(name = "KEY_COUNT")
    private Integer keyCount;

    @Column(name = "COMPONENT_COUNT")
    private Integer componentCount;

    @Column(name = "COMPONENT_DEFS")
    private Integer componentDefs;

    @Column(name = "KEY_FLAGS")
    private Integer keyFlags;

    @Column(name = "KEY_COMPRESSION")
    private Integer keyCompression;

    @Column(name = "SPARSE_CHARACTERS")
    private String sparseCharacters;

    @Column(name = "COMPONENT_FLAGS")
    private Integer componentFlags;

    @Column(name = "COMPONENT_TYPE")
    private Integer componentType;

    @Column(name = "COMPONENT_OFFSET")
    private Integer componentOffset;

    @Column(name = "COMPONENT_LENGTH")
    private Integer componentLength;

    @Column(name = "RECORD_KEY")
    private BigDecimal recordKey;

    @Column(name = "RECORD_DATA")
    private String recordData;

}