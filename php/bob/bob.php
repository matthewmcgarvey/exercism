<?php

class Bob {
  public function respondTo($input) {
    if ($this->forcefullQuestioning($input)) {
      return "Calm down, I know what I'm doing!";
    } elseif ($this->yelling($input)) {
      return "Whoa, chill out!";
    } elseif ($this->questioning($input)) {
      return "Sure.";
    } elseif ($this->silence($input)) {
      return "Fine. Be that way!";
    }
    return "Whatever.";
  }

  private function silence($input) {
    return empty(trim(preg_replace('/\pZ+/u', '', $input)));
  }

  private function yelling($input) {
    return $this->containsLetters($input) && $input === mb_strtoupper($input);
  }

  private function questioning($input) {
    return $this->endsWith(trim($input), '?');
  }

  private function forcefullQuestioning($input) {
    return $this->yelling($input) && $this->questioning($input);
  }

  private function endsWith($input, $expected) {
    return mb_substr($input, -mb_strlen($expected)) === $expected;
  }

  function containsLetters($input) {
    return preg_match( '/[a-zA-Z]/', $input );
}
}