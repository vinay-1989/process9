# MoxWave Tests
- Hindi to Indic API
  - Upsupported Source Language Test
  - Unsupported Source-Target Pair Test
- Hindi to Indic Rules (JSON)
  - Supported Languages Test
  - Hindi To Gujarati
  - Hindi To Punjabi
  - Hindi To Bengali
  - Hindi To Oriya
  - Upload Rule Files Test
  - Reload Rules test
  - Corrupt Rule Files Test
- Indic To Indic Mapping
  - Supported Languages Test
  - Hindi to Marathi
  - Hindi to Kannada
  - Hindi to Telugu
  - Kannada to Telugu
  - Telugu to Kannada
  - Bengali to Bangla
  - Bangla to Bengali

### Rule Based Languages
```
Hindi-Gujarati,Hindi-Bengali, Hindi-Punjabi, Hindi-Oriya
```
### Mapping Based Languages

#### Mapping Rules
```
Hindi-Marathi, Telugu-Kannada, Kannada-Telugu, Hindi-Malayalam
```
### No mapping rules (Same as Hindi)
```
Hindi-Rajasthani,Hindi-Bhojpuri,Hindi-Nepali,Hindi-Dogri,Hindi-Konkani,Bengali-Bangla, Bangla-Bengali
```

## TestCase `IndicToIndicTransliteration`
 - `SupportedLanguagesTest` : To test if correct algo `Rules` or `Map` running for a language
 - Check `Algo` (unsupported languages returns blank Algo)
 - Check expected transliteration (unsupported languages return blank transliteration)
 - `SourceLanguageNormalizationTest`: To test Typing errors and nukta variations
 - `HindiToGujaratiAllCharactersTest`
 - `HindiToGujaratiTest` : **depends on** `HindiToGujaratiAllCharactersTest` Test Hindi Gujarati Rules
 ```
 
- Corpus API
  - Terminology Validation API
- Sentence Break API
  - Prefix/Suffix & normalization test
  - \<n1\> ,\<an1\> tagging test
  - abreviation test
  - Sentence break test
- Wave Tagging APi
  - \<n1\> ,\<an1\> tagging test
  - Entity tagging test 

## Hindi to Indic API

### qa
```json
hi_indic_mapping_api=http://192.168.100.21/localization1.3/MapIanguageAPI.ashx
```
### live
```json
hi_indic_mapping_api=https://www.moxwave.in/localization1.3/MapIanguageAPI.ashx
```
### request content-type
```
Content-Type:application/json; charset=utf-8
```

### POST request payload
```json
{
    "SourceLanguage":"Hindi",
    "Langword":"कमल",
    "TargetLanguage":"Gujarati"
}
```
### reqsponse content-type
```
Content-Type: text/plain; charset=utf-8
```
### response payload
```json
"કમલ"
```
## Hindi To Indic Rules

### Hindi To Gujarati

| Rule | Hindi | Gujarati |
| --- | ---: | ---: |
| Chandra  | ँ | ં | 
| Anuswar  | आं,ऊं,ईं | આં,ઊં,ઈં |
| Anuswar  | ां,  ूं , ीं | ાં,  ૂં , ીં |
| Anuswar  | ंप, ंफ, ंब, ंभ, ंम | ંપ, ંફ, ંબ,ંભ,ંમ |
| Anuswar  | ं | ન્ |
| Nukta  | ड़,ढ़,क़,ख़,ग़,च़,ज़ | ડ,ઢ,ક,ખ,ગ,ચ,જ |
| marathi  | ळ,ऴ, | લ,લ |
| tamil  | ऱ,ऩ | ર,ન |
| Nukta  | ઼ | x  |


## Corpus API

### Terminology validation API (POST)

#### qa
```
http://192.168.100.21/MoxCorpus/corpusapi/ValidateTerminology
```

#### live
```
https://www.moxwave.in/MoxCorpus/corpusapi/ValidateTerminology
```

#### Request Content-Type
```
Content-Type:application/json; charset=utf-8
```

#### Request Payload
```json
{
    "Name":"Paytm", //Terminology name
    "SourceLanguage":"English",
    "TargetLanguage":"Hindi", 
    "SourceText":"Check balance amount in your bank account",
    "TargetText":"अपने बैंक खाते में बकाया अमाउंट चेक करें" 
}
```

#### Response Content-Type
```
Content-Type:application/json; charset=utf-8
```

#### Response Payload
Returns list of input words for which terminology did not match in provided translation 

```json
[
  "balance",
  "account",
  "amount"
],
```

## Sentence Break api (**POST**)

### qa
```
http://192.168.100.21/Localization1.3/SentenceBreak.ashx?key=BEA2-55EF-603A-40D7-A27F-B767-D0B9-8A72
```

### Live
```
http://www.moxwave.in/Localization1.3/SentenceBreak.ashx?key=BEA2-55EF-603A-40D7-A27F-B767-D0B9-8A72
```

### Request Content-Type
```
Content-Type:text/plain; charset=utf-8
```

### Request Payload [English Text]
```
([$0]  discount  applicable)
```

### Response Content-Type
```
Content-Type:application/json; charset=utf-8
```

### Response Payload
List of Sentences with tagging and prefix\suffix in input

```json
{
"SentenceList": [
  {
"engword": "$0 discount applicable",
"an_engword": "[<n1>] discount applicable",
"en_engword": "[<n1>] discount applicable",
"en_prefix": "(",
"en_suffix": ")"
}
],
}
```

### Prefix
| Name | Character | Prefix | Not Prefix|
| --- | ---  | ------- | --- | 
| | (  | (test it) | (test) it |
| | [  | [test it] | [test] it |
| | {  | {test it} | {test} it |
| | \<  | \<test it\> | \<test\> it |
| | "  | "test it" | "test" it |
| | '  | 'test it' | 'test' it |
| | \` | \`test it´ | `test´ it |
| | ‘(\u2018)  | ‘test it’ | ‘test’ it |
| | “(\u201c)  | “test it” | “test” it |
| bullet | \<n1\>. | 1. test | 1.5 gram |
| bullet | a. | a. test | a. r. rehman |
| bullet | a) | a) test |  |
| bullet | * | * test | |
| bullet | (a) | (a) test | |
| bullet(\u2022) | • | • test | |
| bullet | - | - test | |
| mdash(\u2014) |  — | — test | |
| ndash(\u2013) |  – | – test | |
| punctuations |  | : , ; \| ? + ! ~ ) ] } > ’ ”| |
| punctuations |  | | @ # $ % & |




### Suffix
| Name | Character | Suffix | Not Suffix|
| --- | ---  | ------- | --- | 
| | )  | (test it) | (test) it |
| | ]  | [test it] | [test] it |
| | }  | {test it} | {test} it |
| | \>  | \<test it\> | \<test\> it |
| | "  | "test it" | "test" it |
| | '  | 'test it' | 'test' it |
| | \´(\u00b4)  | \`test it´ | `test´ it |
| | ’(\u2019)  | ‘test it’ | ‘test’ it |
| | ”(\u201d)  | “test it” | “test” it |
| punctuations |  | : , ; \| . ~ ( { [ <| |
| punctuations |  | | % ? ! |



## Wave Tagging API
### qa
```
http://192.168.100.21/Localization1.3/tagging.ashx?key=BEA2-55EF-603A-40D7-A27F-B767-D0B9-8A72&ln=hindi
```

### Live
```
http://www.moxwave.in/Localization1.3/SentenceBreak.ashx?key=BEA2-55EF-603A-40D7-A27F-B767-D0B9-8A72
```

### Request Content-Type
```
Content-Type:text/plain; charset=utf-8
```

### Request Payload [English Text]
```
($0 discount applicable)
```

### Response Content-Type
```
Content-Type:application/json; charset=utf-8
```

### Response Payload
List of Sentences with tagging and prefix\suffix in input

```json
{
"SentenceList": [
  {
"engword": "$0 discount applicable",
"an_engword": "<n1> discount applicable",
"en_engword": "<n1> discount applicable",
"en_prefix": "(",
"en_suffix": ")"
}
],
}
```