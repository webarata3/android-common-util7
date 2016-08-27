package link.webarata3.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import link.webarata3.common.enums.LineBreakType;
import link.webarata3.common.util.StringUtil;

public class StringUtilTest {
    @Test
    public void isEmptyのnullの場合() {
        assertThat(StringUtil.isEmpty(null), is(true));
    }

    @Test
    public void isEmptyの空文字の場合() {
        assertThat(StringUtil.isEmpty(""), is(true));
    }

    @Test
    public void isEmptyのABCの場合() {
        assertThat(StringUtil.isEmpty("ABC"), is(false));
    }

    @Test
    public void isEmptyのあの場合() {
        assertThat(StringUtil.isEmpty("あ"), is(false));
    }

    @Test
    public void isNotEmptyのnullの場合() {
        assertThat(StringUtil.isNotEmpty(null), is(false));
    }

    @Test
    public void isNotEmptyの空文字の場合() {
        assertThat(StringUtil.isNotEmpty(""), is(false));
    }

    @Test
    public void isNotEmptyのABCの場合() {
        assertThat(StringUtil.isNotEmpty("ABC"), is(true));
    }

    @Test
    public void isNotEmptyのあの場合() {
        assertThat(StringUtil.isNotEmpty("あ"), is(true));
    }

    @Test
    public void trimLeftの半角ブランクがtrimされること() {
        assertThat(StringUtil.trimLeft(" あいうえお"), is("あいうえお"));
    }

    @Test
    public void trimLeft全角ブランクがtrimされること() {
        assertThat(StringUtil.trimLeft("　あいうえお"), is("あいうえお"));
    }

    @Test
    public void trimLeftのタブがtrimされること() {
        assertThat(StringUtil.trimLeft("\tあいうえお"), is("あいうえお"));
    }

    @Test
    public void trimLeftのLFがtrimされること() {
        assertThat(StringUtil.trimLeft("\nあいうえお"), is("あいうえお"));
    }

    @Test
    public void trimLeftのCRがtrimされること() {
        assertThat(StringUtil.trimLeft("\rあいうえお"), is("あいうえお"));
    }

    @Test
    public void trimLeftのいろいろ混ざった場合にtrimされること() {
        assertThat(StringUtil.trimLeft(" 　\t\nあいうえお"), is("あいうえお"));
    }

    public void trimLeftの右側がtrimされないこと() {
        assertThat(StringUtil.trimLeft("あいうえお\n\t　 "), is("あいうえお\n\t　 "));
    }

    public void trimLeftですべての文字がtrim対象の場合() {
        assertThat(StringUtil.trimLeft(" 　\t\n"), is(""));
    }

    public void trimLeftで空文字の場合() {
        assertThat(StringUtil.trimLeft(""), is(""));
    }

    @Test
    public void trimRightの半角ブランクがtrimされること() {
        assertThat(StringUtil.trimRight("あいうえお "), is("あいうえお"));
    }

    @Test
    public void trimRight全角ブランクがtrimされること() {
        assertThat(StringUtil.trimRight("あいうえお　"), is("あいうえお"));
    }

    @Test
    public void trimRightのタブがtrimされること() {
        assertThat(StringUtil.trimRight("あいうえお\t"), is("あいうえお"));
    }

    @Test
    public void trimRightのLFがtrimされること() {
        assertThat(StringUtil.trimRight("あいうえお\n"), is("あいうえお"));
    }

    @Test
    public void trimRightのCRがtrimされること() {
        assertThat(StringUtil.trimRight("あいうえお\r"), is("あいうえお"));
    }

    @Test
    public void trimRightのいろいろ混ざった場合にtrimされること() {
        assertThat(StringUtil.trimRight("あいうえお 　\t\n"), is("あいうえお"));
    }

    public void trimRightの左側がtrimされないこと() {
        assertThat(StringUtil.trimRight("\n\t　 あいうえお"), is("あいうえお\n\t　 "));
    }

    public void trimRightですべての文字がtrim対象の場合() {
        assertThat(StringUtil.trimRight(" 　\t\n"), is(""));
    }

    public void trimRightで空文字の場合() {
        assertThat(StringUtil.trimRight(""), is(""));
    }

    @Test
    public void trimの半角ブランクがtrimされること() {
        assertThat(StringUtil.trim(" あいうえお "), is("あいうえお"));
    }

    @Test
    public void trim全角ブランクがtrimされること() {
        assertThat(StringUtil.trim("　あいうえお　"), is("あいうえお"));
    }

    @Test
    public void trimのタブがtrimされること() {
        assertThat(StringUtil.trim("\tあいうえお\t"), is("あいうえお"));
    }

    @Test
    public void trimのLFがtrimされること() {
        assertThat(StringUtil.trim("\nあいうえお\n"), is("あいうえお"));
    }

    @Test
    public void trimのCRがtrimされること() {
        assertThat(StringUtil.trim("\rあいうえお\r"), is("あいうえお"));
    }

    @Test
    public void trimのいろいろ混ざった場合にtrimされること() {
        assertThat(StringUtil.trim(" 　\t\nあいうえお 　\t\n"), is("あいうえお"));
    }

    @Test
    public void trimですべての文字が対象の場合() {
        assertThat(StringUtil.trimRight(" 　\t\n"), is(""));
    }

    @Test
    public void trimで空文字の場合() {
        assertThat(StringUtil.trim(""), is(""));
    }

    @Test
    public void normalizeLineBreakでCRに変換する場合() {
        String target = "test\r\ntest\ntest\r";
        String expected = "test\rtest\rtest\r";

        assertThat(StringUtil.normalizeLineBreak(target, LineBreakType.CR), is(expected));
    }

    @Test
    public void normalizeLineBreakでLFに変換する場合() {
        String target = "test\r\ntest\ntest\r";
        String expected = "test\ntest\ntest\n";

        assertThat(StringUtil.normalizeLineBreak(target, LineBreakType.LF), is(expected));
    }

    @Test
    public void normalizeLineBreakでCRLFに変換する場合() {
        String target = "test\r\ntest\ntest\r";
        String expected = "test\r\ntest\r\ntest\r\n";

        assertThat(StringUtil.normalizeLineBreak(target, LineBreakType.CRLF), is(expected));
    }
}