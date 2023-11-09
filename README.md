# 소개

> 세모는 모임을 운영하고자 하는 사용자들과 모임에 참여하고자 하는 사용자들을 대상으로 하는 웹 어플리케이션 입니다.

# 목적
```
최근 코로나19가 종식되고 모임이 활성화됨에 따라 사용자들이 더 쉽게 모임을 생성 및 참여할 수 있게 도와주고자 함

회원 가입 및 로그인, 프로필, 번개 모임 게시글 및 동호회 생성 및 참여, 채팅방, 번개 게시판, 동호회 게시판 등의 기능을 구현하여
사용자들이 효율적으로 모임을 생성 및 운영하고 참여할 수 있는 환경을 제공하는 것을 목표로 함.

또한 매너등급 시스템, 호스트의 초대를 통한 참여 기능과 피드백 기능을 통해 모임이 파투 날 확률을 줄이고 사용자에게 깨끗한 모임 환경을 제공.
```


# 기능
### 사용자 기능

> ##### 1.메인페이지

![메인](https://github.com/focandlol/gathering/assets/50188319/d5e1dfdd-d486-40f2-9d82-1a6ee0553f92)
------------------
> ##### 2.번게 게시판

![번개1](https://github.com/focandlol/gathering/assets/50188319/a9eb03cc-4826-49dc-99e5-0c5b02377daa)
![번개](https://github.com/focandlol/gathering/assets/50188319/9606e337-7117-421a-86b4-4a858731b905)
------------------
> ##### 3.동호회 게시판
![동호회](https://github.com/focandlol/gathering/assets/50188319/506be925-a811-43bb-99b5-600887d6d8cf)
------------------
### 관리자 기능
> ##### 1.관리자 페이지
![구성3](https://github.com/focandlol/gathering/assets/50188319/764dc9a4-fbb3-4b7f-a3c7-790b6d0c372f)



# 구성
![인덱스](https://github.com/focandlol/gathering/assets/50188319/9cd92420-161a-46df-9832-5c81d9c57e26)

![회가](https://github.com/focandlol/gathering/assets/50188319/b1925fe2-53bc-4267-be82-100adb90e64a)
![gmail](https://github.com/focandlol/gathering/assets/50188319/460d0b6e-e935-4551-88ce-7bad71143842)

![프로필](https://github.com/focandlol/gathering/assets/50188319/eb1637fe-1392-4590-b501-76b34191e8f0)

![번개 게시판](https://github.com/focandlol/gathering/assets/50188319/4ef8c0af-3dcf-4aba-a313-0984044ca04a)

**Requirements:**
- Title must match repository, folder and package manager names - or it may have another, relevant title with the repository, folder, and package manager title next to it in italics and in parentheses. For instance:

  ```markdown
  # Standard Readme Style _(standard-readme)_
  ```

  If any of the folder, repository, or package manager names do not match, there must be a note in the [Long Description](#long-description) explaining why.

**Suggestions:**
- Should be self-evident.

### Banner
**Status:** Optional.

**Requirements:**
- Must not have its own title.
- Must link to local image in current repository.
- Must appear directly after the title.

### Badges
**Status:** Optional.

**Requirements:**
- Must not have its own title.
- Must be newline delimited.

**Suggestions:**
- Use http://shields.io or a similar service to create and host the images.
- Add the [Standard Readme badge](https://github.com/RichardLitt/standard-readme#badge).

### Short Description
**Status:** Required.

**Requirements:**
- Must not have its own title.
- Must be less than 120 characters.
- Must not start with `> `
- Must be on its own line.
- Must match the description in the packager manager's `description` field.
- Must match GitHub's description (if on GitHub).

**Suggestions:**
- Use [gh-description](https://github.com/RichardLitt/gh-description) to set and get GitHub description.
- Use `npm show . description` to show the description from a local [npm](https://npmjs.com) package.

### Long Description
**Status:** Optional.

**Requirements:**
- Must not have its own title.
- If any of the folder, repository, or package manager names do not match, there must be a note here as to why. See [Title section](#title).

**Suggestions:**
- If too long, consider moving to the [Background](#background) section.
- Cover the main reasons for building the repository.
- "This should describe your module in broad terms,
generally in just a few paragraphs; more detail of the module's
routines or methods, lengthy code examples, or other in-depth
material should be given in subsequent sections.

  Ideally, someone who's slightly familiar with your module should be
able to refresh their memory without hitting "page down". As your
reader continues through the document, they should receive a
progressively greater amount of knowledge."

  ~ [Kirrily "Skud" Robert, perlmodstyle](http://perldoc.perl.org/perlmodstyle.html)

### Table of Contents
**Status:** Required; optional for READMEs shorter than 100 lines.

**Requirements:**
- Must link to all Markdown sections in the file.
- Must start with the next section; do not include the title or Table of Contents headings.
- Must be at least one-depth: must capture all `##` headings.

**Suggestions:**
- May capture third and fourth depth headings. If it is a long ToC, these are optional.

### Security
**Status**: Optional.

**Requirements:**
- May go here if it is important to highlight security concerns. Otherwise, it should be in [Extra Sections](#extra-sections).

### Background
**Status:** Optional.

**Requirements:**
- Cover motivation.
- Cover abstract dependencies.
- Cover intellectual provenance: A `See Also` section is also fitting.

### Install
**Status:** Required by default, optional for [documentation repositories](#definitions).

**Requirements:**
- Code block illustrating how to install.

**Subsections:**
- `Dependencies`. Required if there are unusual dependencies or dependencies that must be manually installed.

**Suggestions:**
- Link to prerequisite sites for programming language: [npmjs](https://npmjs.com), [godocs](https://godoc.org), etc.
- Include any system-specific information needed for installation.
- An `Updating` section would be useful for most packages, if there are multiple versions which the user may interface with.

### Usage
**Status:** Required by default, optional for [documentation repositories](#definitions).

**Requirements:**
- Code block illustrating common usage.
- If CLI compatible, code block indicating common usage.
- If importable, code block indicating both import functionality and usage.

**Subsections:**
- `CLI`. Required if CLI functionality exists.

**Suggestions:**
- Cover basic choices that may affect usage: for instance, if JavaScript, cover promises/callbacks, ES6 here.
- If relevant, point to a runnable file for the usage code.

### Extra Sections
**Status**: Optional.

**Requirements:**
- None.

**Suggestions:**
- This should not be called `Extra Sections`. This is a space for 0 or more sections to be included, each of which must have their own titles.
- This should contain any other sections that are relevant, placed after [Usage](#usage) and before [API](#api).
- Specifically, the [Security](#security) section should be here if it wasn't important enough to be placed above.

### API
**Status:** Optional.

**Requirements:**
- Describe exported functions and objects.

**Suggestions:**
- Describe signatures, return types, callbacks, and events.
- Cover types covered where not obvious.
- Describe caveats.
- If using an external API generator (like go-doc, js-doc, or so on), point to an external `API.md` file. This can be the only item in the section, if present.

### Maintainer(s)
**Status**: Optional.

**Requirements:**
- Must be called `Maintainer` or `Maintainers`.
- List maintainer(s) for a repository, along with one way of contacting them (e.g. GitHub link or email).

**Suggestions:**
- This should be a small list of people in charge of the repo. This should not be everyone with access rights, such as an entire organization, but the people who should be pinged and who are in charge of the direction and maintenance of the repository.
- Listing past maintainers is good for attribution, and kind.

### Thanks
**Status**: Optional.

**Requirements:**
- Must be called `Thanks`, `Credits` or `Acknowledgements`.

**Suggestions:**
- State anyone or anything that significantly helped with the development of your project.
- State public contact hyper-links if applicable.

### Contributing
**Status**: Required.

**Requirements:**
- State where users can ask questions.
- State whether PRs are accepted.
- List any requirements for contributing; for instance, having a sign-off on commits.

**Suggestions:**
- Link to a CONTRIBUTING file -- if there is one.
- Be as friendly as possible.
- Link to the GitHub issues.
- Link to a Code of Conduct. A CoC is often in the Contributing section or document, or set elsewhere for an entire organization, so it may not be necessary to include the entire file in each repository. However, it is highly recommended to always link to the code, wherever it lives.
- A subsection for listing contributors is also welcome here.

### License
**Status:** Required.

**Requirements:**
- State license full name or identifier, as listed on the  [SPDX](https://spdx.org/licenses/) license list. For unlicensed repositories, add `UNLICENSED`. For more details, add `SEE LICENSE IN <filename>` and link to the license file. (These requirements were adapted from [npm](https://docs.npmjs.com/files/package.json#license)).
- State license owner.
- Must be last section.

**Suggestions:**
- Link to longer License file in local repository.

## Definitions

_These definitions are provided to clarify any terms used above._

- **Documentation repositories**: Repositories without any functional code. For instance, [RichardLitt/knowledge](https://github.com/RichardLitt/knowledge).
