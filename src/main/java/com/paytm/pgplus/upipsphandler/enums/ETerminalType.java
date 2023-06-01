package com.paytm.pgplus.upipsphandler.enums;

import org.apache.commons.lang3.StringUtils;

public enum ETerminalType {
    APP("APP"),
    WEB("WEB"),
    WAP("WAP"),
    SYSTEM("SYSTEM");

    String terminal;

    private ETerminalType(String terminalType) {
        this.terminal = terminalType;
    }

    public String getTerminal() {
        return this.terminal;
    }

    public static ETerminalType getTerminalTypeByTerminal(String terminal) {
        try {
            if (StringUtils.isNotBlank(terminal)) {
                ETerminalType[] var1 = values();
                int var2 = var1.length;

                for(int var3 = 0; var3 < var2; ++var3) {
                    ETerminalType terminalType = var1[var3];
                    if (terminal.equals(terminalType.getTerminal())) {
                        return terminalType;
                    }
                }
            }
        } catch (Exception var5) {
        }

        return null;
    }
}

