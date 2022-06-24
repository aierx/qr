//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.alibaba.fastjson.serializer;

import com.aierx.fastjson.model.UserPO;
import com.alibaba.fastjson.util.ASMUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

public class ASMSerializer_1_UserPO extends JavaBeanSerializer implements ObjectSerializer {
    public Type bookPOList_asm_fieldType = ASMUtils.getMethodType(UserPO.class, "getBookPOList");
    public ObjectSerializer bookPOList_asm_list_item_ser_;
    public ObjectSerializer bookPOList_asm_ser_;
    public Type date_asm_fieldType = ASMUtils.getMethodType(UserPO.class, "getDate");
    public ObjectSerializer date_asm_ser_;

    public ASMSerializer_1_UserPO(SerializeBeanInfo var1) {
        super(var1);
    }

    public void write(JSONSerializer var1, Object var2, Object var3, Type var4, int var5) throws IOException {
        if (var2 == null) {
            var1.writeNull();
        } else {
            SerializeWriter var9 = var1.out;
            if (!this.writeDirect(var1)) {
                this.writeNormal(var1, var2, var3, var4, var5);
            } else if (var9.isEnabled(32768)) {
                this.writeDirectNonContext(var1, var2, var3, var4, var5);
            } else {
                UserPO var10 = (UserPO)var2;
                if (!this.writeReference(var1, var2, var5)) {
                    if (var9.isEnabled(2097152)) {
                        this.writeAsArray(var1, var2, var3, var4, var5);
                    } else {
                        SerialContext var11 = var1.getContext();
                        var1.setContext(var11, var2, var3, 0);
                        char var12 = '{';
                        String var6 = "bookPOList";
                        List var13 = (List)var10.getBookPOList();
                        if (var13 == null) {
                            if (var9.isEnabled(68)) {
                                var9.write(var12);
                                var9.writeFieldNameDirect(var6);
                                var9.writeNull(0, 64);
                                var12 = ',';
                            }
                        } else {
                            var9.write(var12);
                            var9.writeFieldNameDirect(var6);
                            int var14 = var13.size();
                            if (var14 == 0) {
                                var9.write("[]");
                            } else {
                                var1.setContext(var13, var6);
                                var9.write(91);

                                for(int var15 = 0; var15 < var14; ++var15) {
                                    if (var15 != 0) {
                                        var9.write(44);
                                    }

                                    Object var16 = var13.get(var15);
                                    if (var16 == null) {
                                        var9.writeNull();
                                    } else {
                                        var1.writeWithFieldName(var16, var15);
                                    }
                                }

                                var9.write(93);
                                var1.popContext();
                            }

                            var12 = ',';
                        }

                        var6 = "date";
                        Date var17 = var10.getDate();
                        if (var17 == null) {
                            if (var9.isEnabled(964)) {
                                var9.write(var12);
                                var9.writeFieldNameDirect(var6);
                                var9.writeNull(0, 0);
                                var12 = ',';
                            }
                        } else {
                            var9.write(var12);
                            var9.writeFieldNameDirect(var6);
                            var1.writeWithFieldName(var17, var6, this.date_asm_fieldType, 0);
                            var12 = ',';
                        }

                        var6 = "password";
                        String var18 = var10.getPassword();
                        if (var18 == null) {
                            if (var9.isEnabled(132)) {
                                var9.write(var12);
                                var9.writeFieldNameDirect(var6);
                                var9.writeNull(0, 128);
                                var12 = ',';
                            }
                        } else {
                            var9.writeFieldValueStringWithDoubleQuoteCheck(var12, var6, var18);
                            var12 = ',';
                        }

                        var6 = "aaaaaaaaaaaa";
                        var18 = var10.getUsername();
                        if (var18 == null) {
                            if (var9.isEnabled(132)) {
                                var9.write(var12);
                                var9.writeFieldNameDirect(var6);
                                var9.writeNull(0, 128);
                                var12 = ',';
                            }
                        } else {
                            var9.writeFieldValueStringWithDoubleQuoteCheck(var12, var6, var18);
                            var12 = ',';
                        }

                        var6 = "userid";
                        var18 = var10.getUserid();
                        if (var18 == null) {
                            if (var9.isEnabled(132)) {
                                var9.write(var12);
                                var9.writeFieldNameDirect(var6);
                                var9.writeNull(0, 128);
                                var12 = ',';
                            }
                        } else {
                            var9.writeFieldValueStringWithDoubleQuoteCheck(var12, var6, var18);
                            var12 = ',';
                        }

                        var6 = "favorite";
                        var18 = var10.getFavorite();
                        if (var18 == null) {
                            if (var9.isEnabled(132)) {
                                var9.write(var12);
                                var9.writeFieldNameDirect(var6);
                                var9.writeNull(0, 128);
                                var12 = ',';
                            }
                        } else {
                            var9.writeFieldValueStringWithDoubleQuoteCheck(var12, var6, var18);
                            var12 = ',';
                        }

                        var6 = "age";
                        var18 = var10.getAge();
                        if (var18 == null) {
                            if (var9.isEnabled(132)) {
                                var9.write(var12);
                                var9.writeFieldNameDirect(var6);
                                var9.writeNull(0, 128);
                                var12 = ',';
                            }
                        } else {
                            var9.writeFieldValueStringWithDoubleQuoteCheck(var12, var6, var18);
                            var12 = ',';
                        }

                        var6 = "high";
                        var18 = var10.getHigh();
                        if (var18 == null) {
                            if (var9.isEnabled(132)) {
                                var9.write(var12);
                                var9.writeFieldNameDirect(var6);
                                var9.writeNull(0, 128);
                                var12 = ',';
                            }
                        } else {
                            var9.writeFieldValueStringWithDoubleQuoteCheck(var12, var6, var18);
                            var12 = ',';
                        }

                        if (var12 == '{') {
                            var9.write(123);
                        }

                        var9.write(125);
                        var1.setContext(var11);
                    }
                }
            }
        }
    }

    public void writeNormal(JSONSerializer var1, Object var2, Object var3, Type var4, int var5) throws IOException {
        if (var2 == null) {
            var1.writeNull();
        } else {
            SerializeWriter var9 = var1.out;
            if (!var9.isSortField()) {
                this.writeUnsorted(var1, var2, var3, var4, var5);
            } else {
                UserPO var10 = (UserPO)var2;
                if (!var9.isEnabled(8192) && !var9.isEnabled(134217728)) {
                    if (!this.writeReference(var1, var2, var5)) {
                        if (var9.isEnabled(2097152)) {
                            this.writeAsArrayNormal(var1, var2, var3, var4, var5);
                        } else {
                            SerialContext var11 = var1.getContext();
                            var1.setContext(var11, var2, var3, 0);
                            byte var10000;
                            if (var1.isWriteClassName(var4, var2) && var4 != var2.getClass()) {
                                var9.write(123);
                                this.writeClassName(var1, (String)null, var2);
                                var10000 = 44;
                            } else {
                                var10000 = 123;
                            }

                            char var12 = (char)var10000;
                            char var25 = this.writeBefore(var1, var2, var12);
                            boolean var13 = var9.isNotWriteDefaultValue();
                            var1.checkValue(this);
                            boolean var15 = var1.hasNameFilters(this);
                            String var6 = "bookPOList";
                            Object var8;
                            if (this.applyName(var1, var2, var6) && this.applyLabel(var1, "")) {
                                List var16 = (List)var10.getBookPOList();
                                if (var13) {
                                }

                                if (this.apply(var1, var2, var6, var16)) {
                                    if (var15) {
                                        var6 = this.processKey(var1, var2, var6, var16);
                                    }

                                    var8 = this.processValue(var1, this.getBeanContext(0), var2, var6, var16);
                                    if (var16 != var8) {
                                        if (var8 == null) {
                                            if (var9.isEnabled(68)) {
                                                var9.write(var25);
                                                var9.writeFieldName(var6, false);
                                                var9.writeNull(0, 64);
                                                var25 = ',';
                                            }
                                        } else {
                                            var9.write(var25);
                                            var9.writeFieldName(var6, false);
                                            if (var8.getClass() == List.class) {
                                                if (this.bookPOList_asm_ser_ == null) {
                                                    this.bookPOList_asm_ser_ = var1.getObjectWriter(List.class);
                                                }

                                                ObjectSerializer var18 = this.bookPOList_asm_ser_;
                                                if (var18 instanceof JavaBeanSerializer) {
                                                    ((JavaBeanSerializer)var18).write(var1, var8, var6, this.bookPOList_asm_fieldType, 0);
                                                } else {
                                                    var18.write(var1, var8, var6, this.bookPOList_asm_fieldType, 0);
                                                }
                                            } else {
                                                var1.writeWithFieldName(var8, var6, this.bookPOList_asm_fieldType, 0);
                                            }

                                            var25 = ',';
                                        }
                                    } else if (var16 == null) {
                                        if (var9.isEnabled(68)) {
                                            var9.write(var25);
                                            var9.writeFieldName(var6, false);
                                            var9.writeNull(0, 64);
                                            var25 = ',';
                                        }
                                    } else {
                                        var9.write(var25);
                                        var9.writeFieldName(var6, false);
                                        int var19 = var16.size();
                                        if (var19 == 0) {
                                            var9.write("[]");
                                        } else {
                                            var1.setContext(var16, var6);
                                            var9.write(91);

                                            for(int var20 = 0; var20 < var19; ++var20) {
                                                if (var20 != 0) {
                                                    var9.write(44);
                                                }

                                                Object var21 = var16.get(var20);
                                                if (var21 == null) {
                                                    var9.writeNull();
                                                } else {
                                                    var1.writeWithFieldName(var21, var20);
                                                }
                                            }

                                            var9.write(93);
                                            var1.popContext();
                                        }

                                        var25 = ',';
                                    }
                                }
                            }

                            var6 = "date";
                            if (this.applyName(var1, var2, var6) && this.applyLabel(var1, "")) {
                                Date var17 = var10.getDate();
                                if (var13) {
                                }

                                if (this.apply(var1, var2, var6, var17)) {
                                    if (var15) {
                                        var6 = this.processKey(var1, var2, var6, var17);
                                    }

                                    var8 = this.processValue(var1, this.getBeanContext(1), var2, var6, var17);
                                    if (var17 != var8) {
                                        if (var8 == null) {
                                            if (var9.isEnabled(964)) {
                                                var9.write(var25);
                                                var9.writeFieldName(var6, false);
                                                var9.writeNull(0, 0);
                                                var25 = ',';
                                            }
                                        } else {
                                            var9.write(var25);
                                            var9.writeFieldName(var6, false);
                                            var1.writeWithFieldName(var8, var6, this.date_asm_fieldType, 0);
                                            var25 = ',';
                                        }
                                    } else if (var8 == null) {
                                        if (var9.isEnabled(964)) {
                                            var9.write(var25);
                                            var9.writeFieldName(var6, false);
                                            var9.writeNull(0, 0);
                                            var25 = ',';
                                        }
                                    } else {
                                        var9.write(var25);
                                        var9.writeFieldName(var6, false);
                                        var1.writeWithFieldName(var8, var6, this.date_asm_fieldType, 0);
                                        var25 = ',';
                                    }
                                }
                            }

                            var6 = "password";
                            String var22;
                            if (this.applyName(var1, var2, var6) && this.applyLabel(var1, "")) {
                                var22 = var10.getPassword();
                                if (var13) {
                                }

                                if (this.apply(var1, var2, var6, var22)) {
                                    if (var15) {
                                        var6 = this.processKey(var1, var2, var6, var22);
                                    }

                                    var8 = this.processValue(var1, this.getBeanContext(2), var2, var6, var22);
                                    if (var22 != var8) {
                                        if (var8 == null) {
                                            if (var9.isEnabled(132)) {
                                                var9.write(var25);
                                                var9.writeFieldName(var6, false);
                                                var9.writeNull(0, 128);
                                                var25 = ',';
                                            }
                                        } else {
                                            var9.write(var25);
                                            var9.writeFieldName(var6, false);
                                            var1.writeWithFieldName(var8, var6, String.class, 0);
                                            var25 = ',';
                                        }
                                    } else if (var22 == null) {
                                        if (var9.isEnabled(132)) {
                                            var9.write(var25);
                                            var9.writeFieldName(var6, false);
                                            var9.writeNull(0, 128);
                                            var25 = ',';
                                        }
                                    } else {
                                        var9.writeFieldValue(var25, var6, var22);
                                        var25 = ',';
                                    }
                                }
                            }

                            var6 = "aaaaaaaaaaaa";
                            if (this.applyName(var1, var2, var6) && this.applyLabel(var1, "")) {
                                var22 = var10.getUsername();
                                if (var13) {
                                }

                                if (this.apply(var1, var2, var6, var22)) {
                                    if (var15) {
                                        var6 = this.processKey(var1, var2, var6, var22);
                                    }

                                    var8 = this.processValue(var1, this.getBeanContext(3), var2, var6, var22);
                                    if (var22 != var8) {
                                        if (var8 == null) {
                                            if (var9.isEnabled(132)) {
                                                var9.write(var25);
                                                var9.writeFieldName(var6, false);
                                                var9.writeNull(0, 128);
                                                var25 = ',';
                                            }
                                        } else {
                                            var9.write(var25);
                                            var9.writeFieldName(var6, false);
                                            var1.writeWithFieldName(var8, var6, String.class, 0);
                                            var25 = ',';
                                        }
                                    } else if (var22 == null) {
                                        if (var9.isEnabled(132)) {
                                            var9.write(var25);
                                            var9.writeFieldName(var6, false);
                                            var9.writeNull(0, 128);
                                            var25 = ',';
                                        }
                                    } else {
                                        var9.writeFieldValue(var25, var6, var22);
                                        var25 = ',';
                                    }
                                }
                            }

                            var6 = "userid";
                            if (this.applyName(var1, var2, var6) && this.applyLabel(var1, "")) {
                                var22 = var10.getUserid();
                                if (var13) {
                                }

                                if (this.apply(var1, var2, var6, var22)) {
                                    if (var15) {
                                        var6 = this.processKey(var1, var2, var6, var22);
                                    }

                                    var8 = this.processValue(var1, this.getBeanContext(4), var2, var6, var22);
                                    if (var22 != var8) {
                                        if (var8 == null) {
                                            if (var9.isEnabled(132)) {
                                                var9.write(var25);
                                                var9.writeFieldName(var6, false);
                                                var9.writeNull(0, 128);
                                                var25 = ',';
                                            }
                                        } else {
                                            var9.write(var25);
                                            var9.writeFieldName(var6, false);
                                            var1.writeWithFieldName(var8, var6, String.class, 0);
                                            var25 = ',';
                                        }
                                    } else if (var22 == null) {
                                        if (var9.isEnabled(132)) {
                                            var9.write(var25);
                                            var9.writeFieldName(var6, false);
                                            var9.writeNull(0, 128);
                                            var25 = ',';
                                        }
                                    } else {
                                        var9.writeFieldValue(var25, var6, var22);
                                        var25 = ',';
                                    }
                                }
                            }

                            var6 = "favorite";
                            if (this.applyName(var1, var2, var6) && this.applyLabel(var1, "")) {
                                var22 = var10.getFavorite();
                                if (var13) {
                                }

                                if (this.apply(var1, var2, var6, var22)) {
                                    if (var15) {
                                        var6 = this.processKey(var1, var2, var6, var22);
                                    }

                                    var8 = this.processValue(var1, this.getBeanContext(5), var2, var6, var22);
                                    if (var22 != var8) {
                                        if (var8 == null) {
                                            if (var9.isEnabled(132)) {
                                                var9.write(var25);
                                                var9.writeFieldName(var6, false);
                                                var9.writeNull(0, 128);
                                                var25 = ',';
                                            }
                                        } else {
                                            var9.write(var25);
                                            var9.writeFieldName(var6, false);
                                            var1.writeWithFieldName(var8, var6, String.class, 0);
                                            var25 = ',';
                                        }
                                    } else if (var22 == null) {
                                        if (var9.isEnabled(132)) {
                                            var9.write(var25);
                                            var9.writeFieldName(var6, false);
                                            var9.writeNull(0, 128);
                                            var25 = ',';
                                        }
                                    } else {
                                        var9.writeFieldValue(var25, var6, var22);
                                        var25 = ',';
                                    }
                                }
                            }

                            var6 = "age";
                            if (this.applyName(var1, var2, var6) && this.applyLabel(var1, "")) {
                                var22 = var10.getAge();
                                if (var13) {
                                }

                                if (this.apply(var1, var2, var6, var22)) {
                                    if (var15) {
                                        var6 = this.processKey(var1, var2, var6, var22);
                                    }

                                    var8 = this.processValue(var1, this.getBeanContext(6), var2, var6, var22);
                                    if (var22 != var8) {
                                        if (var8 == null) {
                                            if (var9.isEnabled(132)) {
                                                var9.write(var25);
                                                var9.writeFieldName(var6, false);
                                                var9.writeNull(0, 128);
                                                var25 = ',';
                                            }
                                        } else {
                                            var9.write(var25);
                                            var9.writeFieldName(var6, false);
                                            var1.writeWithFieldName(var8, var6, String.class, 0);
                                            var25 = ',';
                                        }
                                    } else if (var22 == null) {
                                        if (var9.isEnabled(132)) {
                                            var9.write(var25);
                                            var9.writeFieldName(var6, false);
                                            var9.writeNull(0, 128);
                                            var25 = ',';
                                        }
                                    } else {
                                        var9.writeFieldValue(var25, var6, var22);
                                        var25 = ',';
                                    }
                                }
                            }

                            var6 = "high";
                            if (this.applyName(var1, var2, var6) && this.applyLabel(var1, "")) {
                                var22 = var10.getHigh();
                                if (var13) {
                                }

                                if (this.apply(var1, var2, var6, var22)) {
                                    if (var15) {
                                        var6 = this.processKey(var1, var2, var6, var22);
                                    }

                                    var8 = this.processValue(var1, this.getBeanContext(7), var2, var6, var22);
                                    if (var22 != var8) {
                                        if (var8 == null) {
                                            if (var9.isEnabled(132)) {
                                                var9.write(var25);
                                                var9.writeFieldName(var6, false);
                                                var9.writeNull(0, 128);
                                                var25 = ',';
                                            }
                                        } else {
                                            var9.write(var25);
                                            var9.writeFieldName(var6, false);
                                            var1.writeWithFieldName(var8, var6, String.class, 0);
                                            var25 = ',';
                                        }
                                    } else if (var22 == null) {
                                        if (var9.isEnabled(132)) {
                                            var9.write(var25);
                                            var9.writeFieldName(var6, false);
                                            var9.writeNull(0, 128);
                                            var25 = ',';
                                        }
                                    } else {
                                        var9.writeFieldValue(var25, var6, var22);
                                        var25 = ',';
                                    }
                                }
                            }

                            var25 = this.writeAfter(var1, var2, var25);
                            if (var25 == '{') {
                                var9.write(123);
                            }

                            var9.write(125);
                            var1.setContext(var11);
                        }
                    }
                } else {
                    super.write(var1, var2, var3, var4, var5);
                }
            }
        }
    }

    public void writeAsArray(JSONSerializer var1, Object var2, Object var3, Type var4, int var5) throws IOException {
        SerializeWriter var9 = var1.out;
        UserPO var10 = (UserPO)var2;
        if (!var1.hasPropertyFilters(this)) {
            super.writeNoneASM(var1, var2, var3, var4, var5);
        } else {
            var9.write(91);
            String var6 = "bookPOList";
            List var11 = (List)var10.getBookPOList();
            if (var11 == null) {
                var9.writeNull();
            } else {
                int var12 = var11.size();
                var9.write(91);

                for(int var13 = 0; var13 < var12; ++var13) {
                    if (var13 != 0) {
                        var9.write(44);
                    }

                    Object var14 = var11.get(var13);
                    if (var14 == null) {
                        var9.writeNull();
                    } else {
                        var1.writeWithFieldName(var14, var13);
                    }
                }

                var9.write(93);
            }

            var9.write(44);
            var6 = "date";
            Date var15;
            if ((var15 = var10.getDate()) == null) {
                var9.writeNull();
            } else if (var15.getClass() == Date.class) {
                if (this.date_asm_ser_ == null) {
                    this.date_asm_ser_ = var1.getObjectWriter(Date.class);
                }

                ObjectSerializer var16 = this.date_asm_ser_;
                if (var16 instanceof JavaBeanSerializer) {
                    ((JavaBeanSerializer)var16).writeAsArrayNonContext(var1, var15, var6, Date.class, 0);
                } else {
                    var16.write(var1, var15, var6, Date.class, 0);
                }
            } else {
                var1.writeWithFieldName(var15, var6, this.date_asm_fieldType, 0);
            }

            var9.write(44);
            var6 = "password";
            var9.writeString(var10.getPassword(), ',');
            var6 = "aaaaaaaaaaaa";
            var9.writeString(var10.getUsername(), ',');
            var6 = "userid";
            var9.writeString(var10.getUserid(), ',');
            var6 = "favorite";
            var9.writeString(var10.getFavorite(), ',');
            var6 = "age";
            var9.writeString(var10.getAge(), ',');
            var6 = "high";
            var9.writeString(var10.getHigh(), ']');
        }
    }

    public void writeUnsorted(JSONSerializer var1, Object var2, Object var3, Type var4, int var5) throws IOException {
        SerializeWriter var9 = var1.out;
        UserPO var10 = (UserPO)var2;
        if (!var9.isEnabled(8192) && !var9.isEnabled(134217728)) {
            if (!this.writeReference(var1, var2, var5)) {
                if (var9.isEnabled(2097152)) {
                    this.writeAsArrayNormal(var1, var2, var3, var4, var5);
                } else {
                    SerialContext var11 = var1.getContext();
                    var1.setContext(var11, var2, var3, 0);
                    byte var10000;
                    if (var1.isWriteClassName(var4, var2) && var4 != var2.getClass()) {
                        var9.write(123);
                        this.writeClassName(var1, (String)null, var2);
                        var10000 = 44;
                    } else {
                        var10000 = 123;
                    }

                    char var12 = (char)var10000;
                    char var25 = this.writeBefore(var1, var2, var12);
                    boolean var13 = var9.isNotWriteDefaultValue();
                    var1.checkValue(this);
                    boolean var15 = var1.hasNameFilters(this);
                    String var6 = "date";
                    Object var8;
                    if (this.applyName(var1, var2, var6) && this.applyLabel(var1, "")) {
                        Date var16 = var10.getDate();
                        if (var13) {
                        }

                        if (this.apply(var1, var2, var6, var16)) {
                            if (var15) {
                                var6 = this.processKey(var1, var2, var6, var16);
                            }

                            var8 = this.processValue(var1, this.getBeanContext(1), var2, var6, var16);
                            if (var16 != var8) {
                                if (var8 == null) {
                                    if (var9.isEnabled(964)) {
                                        var9.write(var25);
                                        var9.writeFieldName(var6, false);
                                        var9.writeNull(0, 0);
                                        var25 = ',';
                                    }
                                } else {
                                    var9.write(var25);
                                    var9.writeFieldName(var6, false);
                                    var1.writeWithFieldName(var8, var6, this.date_asm_fieldType, 0);
                                    var25 = ',';
                                }
                            } else if (var8 == null) {
                                if (var9.isEnabled(964)) {
                                    var9.write(var25);
                                    var9.writeFieldName(var6, false);
                                    var9.writeNull(0, 0);
                                    var25 = ',';
                                }
                            } else {
                                var9.write(var25);
                                var9.writeFieldName(var6, false);
                                var1.writeWithFieldName(var8, var6, this.date_asm_fieldType, 0);
                                var25 = ',';
                            }
                        }
                    }

                    var6 = "high";
                    String var17;
                    if (this.applyName(var1, var2, var6) && this.applyLabel(var1, "")) {
                        var17 = var10.getHigh();
                        if (var13) {
                        }

                        if (this.apply(var1, var2, var6, var17)) {
                            if (var15) {
                                var6 = this.processKey(var1, var2, var6, var17);
                            }

                            var8 = this.processValue(var1, this.getBeanContext(7), var2, var6, var17);
                            if (var17 != var8) {
                                if (var8 == null) {
                                    if (var9.isEnabled(132)) {
                                        var9.write(var25);
                                        var9.writeFieldName(var6, false);
                                        var9.writeNull(0, 128);
                                        var25 = ',';
                                    }
                                } else {
                                    var9.write(var25);
                                    var9.writeFieldName(var6, false);
                                    var1.writeWithFieldName(var8, var6, String.class, 0);
                                    var25 = ',';
                                }
                            } else if (var17 == null) {
                                if (var9.isEnabled(132)) {
                                    var9.write(var25);
                                    var9.writeFieldName(var6, false);
                                    var9.writeNull(0, 128);
                                    var25 = ',';
                                }
                            } else {
                                var9.writeFieldValue(var25, var6, var17);
                                var25 = ',';
                            }
                        }
                    }

                    var6 = "aaaaaaaaaaaa";
                    if (this.applyName(var1, var2, var6) && this.applyLabel(var1, "")) {
                        var17 = var10.getUsername();
                        if (var13) {
                        }

                        if (this.apply(var1, var2, var6, var17)) {
                            if (var15) {
                                var6 = this.processKey(var1, var2, var6, var17);
                            }

                            var8 = this.processValue(var1, this.getBeanContext(3), var2, var6, var17);
                            if (var17 != var8) {
                                if (var8 == null) {
                                    if (var9.isEnabled(132)) {
                                        var9.write(var25);
                                        var9.writeFieldName(var6, false);
                                        var9.writeNull(0, 128);
                                        var25 = ',';
                                    }
                                } else {
                                    var9.write(var25);
                                    var9.writeFieldName(var6, false);
                                    var1.writeWithFieldName(var8, var6, String.class, 0);
                                    var25 = ',';
                                }
                            } else if (var17 == null) {
                                if (var9.isEnabled(132)) {
                                    var9.write(var25);
                                    var9.writeFieldName(var6, false);
                                    var9.writeNull(0, 128);
                                    var25 = ',';
                                }
                            } else {
                                var9.writeFieldValue(var25, var6, var17);
                                var25 = ',';
                            }
                        }
                    }

                    var6 = "favorite";
                    if (this.applyName(var1, var2, var6) && this.applyLabel(var1, "")) {
                        var17 = var10.getFavorite();
                        if (var13) {
                        }

                        if (this.apply(var1, var2, var6, var17)) {
                            if (var15) {
                                var6 = this.processKey(var1, var2, var6, var17);
                            }

                            var8 = this.processValue(var1, this.getBeanContext(5), var2, var6, var17);
                            if (var17 != var8) {
                                if (var8 == null) {
                                    if (var9.isEnabled(132)) {
                                        var9.write(var25);
                                        var9.writeFieldName(var6, false);
                                        var9.writeNull(0, 128);
                                        var25 = ',';
                                    }
                                } else {
                                    var9.write(var25);
                                    var9.writeFieldName(var6, false);
                                    var1.writeWithFieldName(var8, var6, String.class, 0);
                                    var25 = ',';
                                }
                            } else if (var17 == null) {
                                if (var9.isEnabled(132)) {
                                    var9.write(var25);
                                    var9.writeFieldName(var6, false);
                                    var9.writeNull(0, 128);
                                    var25 = ',';
                                }
                            } else {
                                var9.writeFieldValue(var25, var6, var17);
                                var25 = ',';
                            }
                        }
                    }

                    var6 = "userid";
                    if (this.applyName(var1, var2, var6) && this.applyLabel(var1, "")) {
                        var17 = var10.getUserid();
                        if (var13) {
                        }

                        if (this.apply(var1, var2, var6, var17)) {
                            if (var15) {
                                var6 = this.processKey(var1, var2, var6, var17);
                            }

                            var8 = this.processValue(var1, this.getBeanContext(4), var2, var6, var17);
                            if (var17 != var8) {
                                if (var8 == null) {
                                    if (var9.isEnabled(132)) {
                                        var9.write(var25);
                                        var9.writeFieldName(var6, false);
                                        var9.writeNull(0, 128);
                                        var25 = ',';
                                    }
                                } else {
                                    var9.write(var25);
                                    var9.writeFieldName(var6, false);
                                    var1.writeWithFieldName(var8, var6, String.class, 0);
                                    var25 = ',';
                                }
                            } else if (var17 == null) {
                                if (var9.isEnabled(132)) {
                                    var9.write(var25);
                                    var9.writeFieldName(var6, false);
                                    var9.writeNull(0, 128);
                                    var25 = ',';
                                }
                            } else {
                                var9.writeFieldValue(var25, var6, var17);
                                var25 = ',';
                            }
                        }
                    }

                    var6 = "bookPOList";
                    if (this.applyName(var1, var2, var6) && this.applyLabel(var1, "")) {
                        List var18 = (List)var10.getBookPOList();
                        if (var13) {
                        }

                        if (this.apply(var1, var2, var6, var18)) {
                            if (var15) {
                                var6 = this.processKey(var1, var2, var6, var18);
                            }

                            var8 = this.processValue(var1, this.getBeanContext(0), var2, var6, var18);
                            if (var18 != var8) {
                                if (var8 == null) {
                                    if (var9.isEnabled(68)) {
                                        var9.write(var25);
                                        var9.writeFieldName(var6, false);
                                        var9.writeNull(0, 64);
                                        var25 = ',';
                                    }
                                } else {
                                    var9.write(var25);
                                    var9.writeFieldName(var6, false);
                                    if (var8.getClass() == List.class) {
                                        if (this.bookPOList_asm_ser_ == null) {
                                            this.bookPOList_asm_ser_ = var1.getObjectWriter(List.class);
                                        }

                                        ObjectSerializer var19 = this.bookPOList_asm_ser_;
                                        if (var19 instanceof JavaBeanSerializer) {
                                            ((JavaBeanSerializer)var19).write(var1, var8, var6, this.bookPOList_asm_fieldType, 0);
                                        } else {
                                            var19.write(var1, var8, var6, this.bookPOList_asm_fieldType, 0);
                                        }
                                    } else {
                                        var1.writeWithFieldName(var8, var6, this.bookPOList_asm_fieldType, 0);
                                    }

                                    var25 = ',';
                                }
                            } else if (var18 == null) {
                                if (var9.isEnabled(68)) {
                                    var9.write(var25);
                                    var9.writeFieldName(var6, false);
                                    var9.writeNull(0, 64);
                                    var25 = ',';
                                }
                            } else {
                                var9.write(var25);
                                var9.writeFieldName(var6, false);
                                int var20 = var18.size();
                                if (var20 == 0) {
                                    var9.write("[]");
                                } else {
                                    var1.setContext(var18, var6);
                                    var9.write(91);

                                    for(int var21 = 0; var21 < var20; ++var21) {
                                        if (var21 != 0) {
                                            var9.write(44);
                                        }

                                        Object var22 = var18.get(var21);
                                        if (var22 == null) {
                                            var9.writeNull();
                                        } else {
                                            var1.writeWithFieldName(var22, var21);
                                        }
                                    }

                                    var9.write(93);
                                    var1.popContext();
                                }

                                var25 = ',';
                            }
                        }
                    }

                    var6 = "age";
                    if (this.applyName(var1, var2, var6) && this.applyLabel(var1, "")) {
                        var17 = var10.getAge();
                        if (var13) {
                        }

                        if (this.apply(var1, var2, var6, var17)) {
                            if (var15) {
                                var6 = this.processKey(var1, var2, var6, var17);
                            }

                            var8 = this.processValue(var1, this.getBeanContext(6), var2, var6, var17);
                            if (var17 != var8) {
                                if (var8 == null) {
                                    if (var9.isEnabled(132)) {
                                        var9.write(var25);
                                        var9.writeFieldName(var6, false);
                                        var9.writeNull(0, 128);
                                        var25 = ',';
                                    }
                                } else {
                                    var9.write(var25);
                                    var9.writeFieldName(var6, false);
                                    var1.writeWithFieldName(var8, var6, String.class, 0);
                                    var25 = ',';
                                }
                            } else if (var17 == null) {
                                if (var9.isEnabled(132)) {
                                    var9.write(var25);
                                    var9.writeFieldName(var6, false);
                                    var9.writeNull(0, 128);
                                    var25 = ',';
                                }
                            } else {
                                var9.writeFieldValue(var25, var6, var17);
                                var25 = ',';
                            }
                        }
                    }

                    var6 = "password";
                    if (this.applyName(var1, var2, var6) && this.applyLabel(var1, "")) {
                        var17 = var10.getPassword();
                        if (var13) {
                        }

                        if (this.apply(var1, var2, var6, var17)) {
                            if (var15) {
                                var6 = this.processKey(var1, var2, var6, var17);
                            }

                            var8 = this.processValue(var1, this.getBeanContext(2), var2, var6, var17);
                            if (var17 != var8) {
                                if (var8 == null) {
                                    if (var9.isEnabled(132)) {
                                        var9.write(var25);
                                        var9.writeFieldName(var6, false);
                                        var9.writeNull(0, 128);
                                        var25 = ',';
                                    }
                                } else {
                                    var9.write(var25);
                                    var9.writeFieldName(var6, false);
                                    var1.writeWithFieldName(var8, var6, String.class, 0);
                                    var25 = ',';
                                }
                            } else if (var17 == null) {
                                if (var9.isEnabled(132)) {
                                    var9.write(var25);
                                    var9.writeFieldName(var6, false);
                                    var9.writeNull(0, 128);
                                    var25 = ',';
                                }
                            } else {
                                var9.writeFieldValue(var25, var6, var17);
                                var25 = ',';
                            }
                        }
                    }

                    var25 = this.writeAfter(var1, var2, var25);
                    if (var25 == '{') {
                        var9.write(123);
                    }

                    var9.write(125);
                    var1.setContext(var11);
                }
            }
        } else {
            super.write(var1, var2, var3, var4, var5);
        }
    }

    public void writeAsArrayNonContext(JSONSerializer var1, Object var2, Object var3, Type var4, int var5) throws IOException {
        SerializeWriter var9 = var1.out;
        UserPO var10 = (UserPO)var2;
        if (!var1.hasPropertyFilters(this)) {
            super.writeNoneASM(var1, var2, var3, var4, var5);
        } else {
            var9.write(91);
            String var6 = "bookPOList";
            List var11 = (List)var10.getBookPOList();
            if (var11 == null) {
                var9.writeNull();
            } else {
                int var12 = var11.size();
                var9.write(91);

                for(int var13 = 0; var13 < var12; ++var13) {
                    if (var13 != 0) {
                        var9.write(44);
                    }

                    Object var14 = var11.get(var13);
                    if (var14 == null) {
                        var9.writeNull();
                    } else {
                        var1.writeWithFieldName(var14, (Object)null);
                    }
                }

                var9.write(93);
            }

            var9.write(44);
            var6 = "date";
            Date var15;
            if ((var15 = var10.getDate()) == null) {
                var9.writeNull();
            } else if (var15.getClass() == Date.class) {
                if (this.date_asm_ser_ == null) {
                    this.date_asm_ser_ = var1.getObjectWriter(Date.class);
                }

                ObjectSerializer var16 = this.date_asm_ser_;
                if (var16 instanceof JavaBeanSerializer) {
                    ((JavaBeanSerializer)var16).writeAsArrayNonContext(var1, var15, var6, Date.class, 0);
                } else {
                    var16.write(var1, var15, var6, Date.class, 0);
                }
            } else {
                var1.writeWithFieldName(var15, var6, this.date_asm_fieldType, 0);
            }

            var9.write(44);
            var6 = "password";
            var9.writeString(var10.getPassword(), ',');
            var6 = "aaaaaaaaaaaa";
            var9.writeString(var10.getUsername(), ',');
            var6 = "userid";
            var9.writeString(var10.getUserid(), ',');
            var6 = "favorite";
            var9.writeString(var10.getFavorite(), ',');
            var6 = "age";
            var9.writeString(var10.getAge(), ',');
            var6 = "high";
            var9.writeString(var10.getHigh(), ']');
        }
    }

    public void writeDirectNonContext(JSONSerializer var1, Object var2, Object var3, Type var4, int var5) throws IOException {
        if (var2 == null) {
            var1.writeNull();
        } else {
            SerializeWriter var9 = var1.out;
            UserPO var10 = (UserPO)var2;
            if (var9.isEnabled(2097152)) {
                this.writeAsArrayNonContext(var1, var2, var3, var4, var5);
            } else {
                char var11 = '{';
                String var6 = "bookPOList";
                List var12 = (List)var10.getBookPOList();
                if (var12 == null) {
                    if (var9.isEnabled(68)) {
                        var9.write(var11);
                        var9.writeFieldNameDirect(var6);
                        var9.writeNull(0, 64);
                        var11 = ',';
                    }
                } else {
                    var9.write(var11);
                    var9.writeFieldNameDirect(var6);
                    int var13 = var12.size();
                    if (var13 == 0) {
                        var9.write("[]");
                    } else {
                        var9.write(91);

                        for(int var14 = 0; var14 < var13; ++var14) {
                            if (var14 != 0) {
                                var9.write(44);
                            }

                            Object var15 = var12.get(var14);
                            if (var15 == null) {
                                var9.writeNull();
                            } else {
                                var1.writeWithFieldName(var15, (Object)null);
                            }
                        }

                        var9.write(93);
                        var1.popContext();
                    }

                    var11 = ',';
                }

                var6 = "date";
                Date var16 = var10.getDate();
                if (var16 == null) {
                    if (var9.isEnabled(964)) {
                        var9.write(var11);
                        var9.writeFieldNameDirect(var6);
                        var9.writeNull(0, 0);
                        var11 = ',';
                    }
                } else {
                    var9.write(var11);
                    var9.writeFieldNameDirect(var6);
                    var1.writeWithFieldName(var16, var6, this.date_asm_fieldType, 0);
                    var11 = ',';
                }

                var6 = "password";
                String var17 = var10.getPassword();
                if (var17 == null) {
                    if (var9.isEnabled(132)) {
                        var9.write(var11);
                        var9.writeFieldNameDirect(var6);
                        var9.writeNull(0, 128);
                        var11 = ',';
                    }
                } else {
                    var9.writeFieldValueStringWithDoubleQuoteCheck(var11, var6, var17);
                    var11 = ',';
                }

                var6 = "aaaaaaaaaaaa";
                var17 = var10.getUsername();
                if (var17 == null) {
                    if (var9.isEnabled(132)) {
                        var9.write(var11);
                        var9.writeFieldNameDirect(var6);
                        var9.writeNull(0, 128);
                        var11 = ',';
                    }
                } else {
                    var9.writeFieldValueStringWithDoubleQuoteCheck(var11, var6, var17);
                    var11 = ',';
                }

                var6 = "userid";
                var17 = var10.getUserid();
                if (var17 == null) {
                    if (var9.isEnabled(132)) {
                        var9.write(var11);
                        var9.writeFieldNameDirect(var6);
                        var9.writeNull(0, 128);
                        var11 = ',';
                    }
                } else {
                    var9.writeFieldValueStringWithDoubleQuoteCheck(var11, var6, var17);
                    var11 = ',';
                }

                var6 = "favorite";
                var17 = var10.getFavorite();
                if (var17 == null) {
                    if (var9.isEnabled(132)) {
                        var9.write(var11);
                        var9.writeFieldNameDirect(var6);
                        var9.writeNull(0, 128);
                        var11 = ',';
                    }
                } else {
                    var9.writeFieldValueStringWithDoubleQuoteCheck(var11, var6, var17);
                    var11 = ',';
                }

                var6 = "age";
                var17 = var10.getAge();
                if (var17 == null) {
                    if (var9.isEnabled(132)) {
                        var9.write(var11);
                        var9.writeFieldNameDirect(var6);
                        var9.writeNull(0, 128);
                        var11 = ',';
                    }
                } else {
                    var9.writeFieldValueStringWithDoubleQuoteCheck(var11, var6, var17);
                    var11 = ',';
                }

                var6 = "high";
                var17 = var10.getHigh();
                if (var17 == null) {
                    if (var9.isEnabled(132)) {
                        var9.write(var11);
                        var9.writeFieldNameDirect(var6);
                        var9.writeNull(0, 128);
                        var11 = ',';
                    }
                } else {
                    var9.writeFieldValueStringWithDoubleQuoteCheck(var11, var6, var17);
                    var11 = ',';
                }

                if (var11 == '{') {
                    var9.write(123);
                }

                var9.write(125);
            }
        }
    }

    public void writeAsArrayNormal(JSONSerializer var1, Object var2, Object var3, Type var4, int var5) throws IOException {
        SerializeWriter var9 = var1.out;
        UserPO var10 = (UserPO)var2;
        if (!var1.hasPropertyFilters(this)) {
            super.writeNoneASM(var1, var2, var3, var4, var5);
        } else {
            var9.write(91);
            String var6 = "bookPOList";
            List var11 = (List)var10.getBookPOList();
            if (var11 == null) {
                var9.writeNull();
            } else {
                int var12 = var11.size();
                var9.write(91);

                for(int var13 = 0; var13 < var12; ++var13) {
                    if (var13 != 0) {
                        var9.write(44);
                    }

                    Object var14 = var11.get(var13);
                    if (var14 == null) {
                        var9.writeNull();
                    } else {
                        var1.writeWithFieldName(var14, var13);
                    }
                }

                var9.write(93);
            }

            var9.write(44);
            var6 = "date";
            Date var15;
            if ((var15 = var10.getDate()) == null) {
                var9.writeNull();
            } else if (var15.getClass() == Date.class) {
                if (this.date_asm_ser_ == null) {
                    this.date_asm_ser_ = var1.getObjectWriter(Date.class);
                }

                ObjectSerializer var16 = this.date_asm_ser_;
                var16.write(var1, var15, var6, Date.class, 0);
            } else {
                var1.writeWithFieldName(var15, var6, this.date_asm_fieldType, 0);
            }

            var9.write(44);
            var6 = "password";
            var9.writeString(var10.getPassword(), ',');
            var6 = "aaaaaaaaaaaa";
            var9.writeString(var10.getUsername(), ',');
            var6 = "userid";
            var9.writeString(var10.getUserid(), ',');
            var6 = "favorite";
            var9.writeString(var10.getFavorite(), ',');
            var6 = "age";
            var9.writeString(var10.getAge(), ',');
            var6 = "high";
            var9.writeString(var10.getHigh(), ']');
        }
    }
}
