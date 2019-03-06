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
    return empty(preg_replace('/\s+/', '', $input));
  }

  private function yelling($input) {
    return $this->contains_letters($input) && $input == strtoupper($input);
  }

  private function questioning($input) {
    return $this->endsWith(trim($input), "?");
  }

  private function forcefullQuestioning($input) {
    return $this->yelling($input) && $this->questioning($input);
  }

  private function endsWith($input, $expected) {
    return substr($input, -strlen($expected)) == $expected;
  }

  function contains_letters($input) {
    return preg_match( '/[a-zA-Z]/', $input );
}
}